package com.hema.medical_backend_spring.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import com.hema.medical_backend_spring.model.ProjectUser;

public class CustomUserDetails implements UserDetails, CredentialsContainer {
   private static final long serialVersionUID = 620L;
   private static final Log logger = LogFactory.getLog(CustomUserDetails.class);
   private String password;
   private final String username;
   private final Set<GrantedAuthority> authorities;
   private final boolean accountNonExpired;
   private final boolean accountNonLocked;
   private final boolean credentialsNonExpired;
   private final boolean enabled;
   private final boolean isActive;
   private final ProjectUser projectUser;

   public CustomUserDetails(String username, String password,ProjectUser projectUser,boolean isActive, Collection<? extends GrantedAuthority> authorities) {
      this(username, password,projectUser, isActive,true, true, true, true, authorities);
   }

   public CustomUserDetails(String username, String password,ProjectUser projectUser,boolean isActive , boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
      Assert.isTrue(username != null && !"".equals(username) && password != null, "Cannot pass null or empty values to constructor");
      this.username = username;
      this.password = password;
      this.projectUser = projectUser;
      this.isActive = isActive;
      this.enabled = enabled;
      this.accountNonExpired = accountNonExpired;
      this.credentialsNonExpired = credentialsNonExpired;
      this.accountNonLocked = accountNonLocked;
      this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
   }

   public Collection<GrantedAuthority> getAuthorities() {
      return this.authorities;
   }

   public String getPassword() {
      return this.password;
   }

   public ProjectUser getProjectUser(){
    return this.projectUser;
   }

   public String getUsername() {
      return this.username;
   }

   public boolean isEnabled() {
      return this.enabled;
   }
   public boolean isActive() {
      return this.isActive;
   }

   public boolean isAccountNonExpired() {
      return this.accountNonExpired;
   }

   public boolean isAccountNonLocked() {
      return this.accountNonLocked;
   }

   public boolean isCredentialsNonExpired() {
      return this.credentialsNonExpired;
   }

   public void eraseCredentials() {
      this.password = null;
   }

   private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
      Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
      SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet(new AuthorityComparator());

      for(GrantedAuthority grantedAuthority : authorities) {
         Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
         sortedAuthorities.add(grantedAuthority);
      }

      return sortedAuthorities;
   }

   public boolean equals(Object obj) {
      if (obj instanceof CustomUserDetails user) {
         return this.username.equals(user.getUsername());
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.username.hashCode();
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(this.getClass().getName()).append(" [");
      sb.append("Username=").append(this.username).append(", ");
      sb.append("Password=[PROTECTED], ");
      sb.append("Enabled=").append(this.enabled).append(", ");
      sb.append("AccountNonExpired=").append(this.accountNonExpired).append(", ");
      sb.append("CredentialsNonExpired=").append(this.credentialsNonExpired).append(", ");
      sb.append("AccountNonLocked=").append(this.accountNonLocked).append(", ");
      sb.append("Granted Authorities=").append(this.authorities).append("]");
      return sb.toString();
   }

   public static UserBuilder withUsername(String username) {
      return builder().username(username);
   }

   public static UserBuilder builder() {
      return new UserBuilder();
   }

   /** @deprecated */
   @Deprecated
   public static UserBuilder withDefaultPasswordEncoder() {
      logger.warn("User.withDefaultPasswordEncoder() is considered unsafe for production and is only intended for sample applications.");
      PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
      UserBuilder var10000 = builder();
      Objects.requireNonNull(encoder);
      return var10000.passwordEncoder(encoder::encode);
   }

   public static UserBuilder withUserDetails(UserDetails userDetails) {
      return withUsername(userDetails.getUsername()).password(userDetails.getPassword()).accountExpired(!userDetails.isAccountNonExpired()).accountLocked(!userDetails.isAccountNonLocked()).authorities(userDetails.getAuthorities()).credentialsExpired(!userDetails.isCredentialsNonExpired()).disabled(!userDetails.isEnabled());
   }

   private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
      private static final long serialVersionUID = 620L;

      private AuthorityComparator() {
      }

      public int compare(GrantedAuthority g1, GrantedAuthority g2) {
         if (g2.getAuthority() == null) {
            return -1;
         } else {
            return g1.getAuthority() == null ? 1 : g1.getAuthority().compareTo(g2.getAuthority());
         }
      }
   }

   public static final class UserBuilder {
      private String username;
      private String password;
      private ProjectUser projectUser;
      private List<GrantedAuthority> authorities = new ArrayList();
      private boolean isActive;
      private boolean accountExpired;
      private boolean accountLocked;
      private boolean credentialsExpired;
      private boolean disabled;
      private Function<String, String> passwordEncoder = (password) -> password;

      private UserBuilder() {
      }

      public UserBuilder username(String username) {
         Assert.notNull(username, "username cannot be null");
         this.username = username;
         return this;
      }
      public UserBuilder projectUser(ProjectUser projectUser) {
         Assert.notNull(projectUser, "username cannot be null");
         this.projectUser = projectUser;
         return this;
      }

      public UserBuilder password(String password) {
         Assert.notNull(password, "password cannot be null");
         this.password = password;
         return this;
      }

      public UserBuilder passwordEncoder(Function<String, String> encoder) {
         Assert.notNull(encoder, "encoder cannot be null");
         this.passwordEncoder = encoder;
         return this;
      }

      public UserBuilder roles(String... roles) {
         List<GrantedAuthority> authorities = new ArrayList(roles.length);

         for(String role : roles) {
            Assert.isTrue(!role.startsWith("ROLE_"), () -> role + " cannot start with ROLE_ (it is automatically added)");
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
         }

         return this.authorities((Collection)authorities);
      }

      public UserBuilder authorities(GrantedAuthority... authorities) {
         Assert.notNull(authorities, "authorities cannot be null");
         return this.authorities((Collection)Arrays.asList(authorities));
      }

      public UserBuilder authorities(Collection<? extends GrantedAuthority> authorities) {
         Assert.notNull(authorities, "authorities cannot be null");
         this.authorities = new ArrayList(authorities);
         return this;
      }

      public UserBuilder authorities(String... authorities) {
         Assert.notNull(authorities, "authorities cannot be null");
         return this.authorities((Collection)AuthorityUtils.createAuthorityList(authorities));
      }

      public UserBuilder accountExpired(boolean accountExpired) {
         this.accountExpired = accountExpired;
         return this;
      }
      public UserBuilder isActive(boolean isActive) {
         this.isActive = isActive;
         return this;
      }

      public UserBuilder accountLocked(boolean accountLocked) {
         this.accountLocked = accountLocked;
         return this;
      }

      public UserBuilder credentialsExpired(boolean credentialsExpired) {
         this.credentialsExpired = credentialsExpired;
         return this;
      }

      public UserBuilder disabled(boolean disabled) {
         this.disabled = disabled;
         return this;
      }

      public UserDetails build() {
         String encodedPassword = (String)this.passwordEncoder.apply(this.password);
         return new CustomUserDetails(this.username, encodedPassword, this.projectUser,this.isActive , !this.disabled, !this.accountExpired, !this.credentialsExpired, !this.accountLocked, this.authorities);
      }
   }
}
