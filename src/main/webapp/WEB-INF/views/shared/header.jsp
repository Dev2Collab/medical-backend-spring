<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header>
    <div>
        <div class="header-logo-holder">
            <img src="./svgs/logo.svg" alt="logo" class="logo">
        </div>
        عيادة الشفاء
    </div>
    <nav>
        <ul>
            <li><a href="/home" class='<%= request.getRequestURI().equals("/WEB-INF/views/home.jsp") ? "active" : "" %>'> الرئيسية</a> </li>
            <li><a href="/book-appointment" class="<%= request.getRequestURI().equals("/WEB-INF/views/appointment.jsp") ? "active" : "" %>"> حجز موعد </a> </li>
            <li><a href="/about" class="<%= request.getRequestURI().equals("/WEB-INF/views/about.jsp") ? "active" : "" %>">عن العيادة </a> </li>
            <li><a href="/services" class="<%= request.getRequestURI().equals("/WEB-INF/views/services.jsp") ? "active" : "" %>">الخدمات</a> </li>
            <li><a href="/doctors" class="<%= request.getRequestURI().equals("/WEB-INF/views/doctors.jsp") ? "active" : "" %>">الاطباء</a> </li>
            <li><a href="/contact" class="<%= request.getRequestURI().equals("/WEB-INF/views/contact.jsp") ? "active" : "" %>">اتصل بنا </a> </li>
        </ul>
    </nav>
    <div class="header-btn">
        <a href="/signup" type="submit" class="btn btn-secondary " >  انشاء حساب
        </a>
        <a href="/login" type="submit" class="btn btn-primary " >  سجل دخولك
        </a>
    </div>
    <div class="menu-toggle">
        ☰
    </div>
    <div class="mobile-menu">
        <ul>
            <li><a href="/home" class='<%= request.getRequestURI().equals("/WEB-INF/views/home.jsp") ? "active" : "" %>'> الرئيسية</a> </li>
            <li><a href="/book-appointment" class="<%= request.getRequestURI().equals("/WEB-INF/views/appointment.jsp") ? "active" : "" %>"> حجز موعد </a> </li>
            <li><a href="/about" class="<%= request.getRequestURI().equals("/WEB-INF/views/about.jsp") ? "active" : "" %>">عن العيادة </a> </li>
            <li><a href="/services" class="<%= request.getRequestURI().equals("/WEB-INF/views/services.jsp") ? "active" : "" %>">الخدمات</a> </li>
            <li><a href="/doctors" class="<%= request.getRequestURI().equals("/WEB-INF/views/doctors.jsp") ? "active" : "" %>">الاطباء</a> </li>
            <li><a href="/contact" class="<%= request.getRequestURI().equals("/WEB-INF/views/contact.jsp") ? "active" : "" %>">اتصل بنا </a> </li>
            <li>
            <a href="/login" class="<%= request.getRequestURI().equals("/WEB-INF/views/login.jsp") ? "active" : "" %>"> سجل دخولك </a> </li>
            <li><a href="/signup" class="<%= request.getRequestURI().equals("/WEB-INF/views/signup.jsp") ? "active" : "" %>"> انشاء حساب </a> </li>
        </ul>
    </div>
    <script>
        const toggleBtn = document.querySelector('.menu-toggle');
        const mobileMenu = document.querySelector('.mobile-menu');
        
        toggleBtn.addEventListener('click', () => {
            mobileMenu.style.display =
            mobileMenu.style.display === 'block' ? 'none' : 'block';
        });
    </script>


</header>