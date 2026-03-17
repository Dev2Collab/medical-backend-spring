<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>signup</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/signup.css">
    </head>
    <body >
        <%-- full window --%>
        <main class="login-main">
            <%-- form card --%>
            <div class="card">

                <div class="right-side">

                    <div class="hero">
                        <%-- logo --%>
                        <div class="logo-holder">
                            <img src="./svgs/med_bag.svg" alt="logo" class="logo">
                        </div>
                        <div class="hero-header">عايتك الصحية،
                            <br>
                            أولويتنا</div>
                            <div class="hr"></div>

                            <div class="sub-hero-header">نقدم لك تجربة طبية فريدة تجمع بين الرقي
                                والاحترافية العالمية في قلب العيادة.</div>

                                <div class="bottom-text">Premium Medical Care</div>
                            </div>
                        </div>

                        <div class="left-side">
                            <%-- text --%>
                            <div class="header-text">إنشاء حساب جديد</div>
                            <div class="hero-sub-header">انضم إلى نخبة مرضانا واستمتع بخدماتنا المتميزة</div>

                            <%-- form details --%>
                            <form >

                                <div class="mb-3">
                                    <label for="fullName" class="form-label" >الاسم بالكامل   </label>

                                    <div  class="input-holder">
                                        <input  type="text" class="form-control" id="fullName" placeholder="ادخل اسمك الثلاثي ">
                                        <span>   <img src="./svgs/person.svg" alt="icon">
                                        </span>
                                    </div>
                                </div>

                                <div class="group-input">
                                    <div class="mb-3">
                                        <label for="phoneNumber" class="form-label"> رقم الهاتف </label>

                                        <div  class="input-holder">
                                            <input  type="text" class="form-control" id="phoneNumber" placeholder="011*********">
                                            <span>   <img src="./svgs/phone.svg" alt=" icon">
                                            </span>
                                        </div>
                                    </div>

                                    <div class="mb-3">
                                        <label for="email" class="form-label">البريد الالكتروني </label>

                                        <div  class="input-holder">
                                            <input  type="email" class="form-control" id="email" placeholder="hema@example.com">
                                            <span>   <img src="./svgs/at_mark.svg" alt="email icon">
                                            </span>
                                        </div>
                                    </div>



                                    <div class="mb-3">
                                        <label for="password" class="form-label">كلمة المرور </label>
                                        <div class="input-holder">
                                            <input type="password" class="form-control" id="password" placeholder="Enter your password">
                                            <span onclick="togglePassword()"><img src="./svgs/lock.svg" alt="icon"></span>
                                        </div>
                                    </div>

                                    <div class="mb-3">
                                        <label for="password-check" class="form-label">تاكيد كلمة المرور </label>
                                        <div class="input-holder">
                                            <input type="password" class="form-control" id="password-check" placeholder="Enter your password">
                                            <span onclick="togglePassword()"><img src="./svgs/lock-load.svg" alt="icon"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="checkChecked" checked>
  <label class="form-check-label" for="checkChecked">
                                        أوافق على
                                        <a href="#">الشروط والأحكام</a>
                                        و
                                        <a href="#">سياسة الخصوصية</a>
                                    </label>
</div>

                                <button type="submit" class="btn-signup" >  انشاء الحساب 
                                    <img src="./svgs/arrow-left.svg" alt="icon" style="margin-right: 16px;">
                                </button>
                            </form>

                            <div class="login-box">
                                <div class="login-link">
                                     لديك حساب بالفعل ؟
                                    <a href="/login"> سجل دخولك الان</a>
                                </div>
                            </div>
                        </div>

                    </div><%-- end card --%>
                </main>
                <footer>&copy;  <%= java.time.Year.now().getValue() %> العيادة الملكية - جميع الحقوق محفوظة</footer>
                <script src="./js/bootstrap.min.js"></script>
                <script >
                    function togglePassword() {
                        const input = document.getElementById('password');
                        const input2 = document.getElementById('password-check');
                        if (input.type === "password") {
                            input.type = "text";
                            input2.type = "text";
                            
                            } else {
                                input.type = "password";
                                input2.type = "password";
                            }
                        }
                    </script>
                </body>
            </html>
