<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Appointment </title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./style.css">
        <link rel="stylesheet" href="./css/appointment.css">
    </head>
    <body>
        <div class="container">
            <%@ include file="shared/header.jsp" %>
            <section class="text-center">
                <div class="flex-column">
                    <div class="icon-holder">
                        <img src="/svgs/calender.svg" alt="icon"/>
                    </div>
                    <div>
                        <h1 class="text-primary">
                            نموذج حجز المواعيد أونلاين
                        </h1>
                        <div class="app-hr"><span class="footer-hr"></span></div>
                        <p class="text-secondary">
                            يسعدنا انضمامكم لمركزنا. يرجى تعبئة البيانات المطلوبة بدقة لضمان حصولكم على أفضل
                            <br>
                            رعاية طبية في الموعد المفضل.
                        </p>
                    </div>
                    <div class="form row">
                        <div class="top-gradient"></div>
                        <form >
                            <div class="flex text-primary mb-2 mt-2" >
                                <img src="/svgs/book-person.svg" style="margin-inline:8px;"/>
                                البيانات الشخصية للمريض
                            </div>

                            <div class="row  justify-content-around">
                                <div class="mb-3 col-md-5" >
                                    <label for="fullName" class="form-label" >الاسم بالكامل   </label>
                                    <div  class="input-holder">
                                        <input  type="text" class="form-control" id="fullName" placeholder="ادخل اسمك الثلاثي ">
                                        <span>   <img src="./svgs/person.svg" alt="icon">
                                        </span>
                                    </div>
                                </div>
                                <div class="mb-3 col-md-5">
                                    <label for="phoneNumber" class="form-label"> رقم الهاتف </label>

                                    <div  class="input-holder">
                                        <input  type="text" class="form-control" id="phoneNumber" placeholder="011*********">
                                        <span>   <img src="./svgs/phone.svg" alt=" icon">
                                        </span>
                                    </div>
                                </div>
                            </div>


                            <div class="flex text-primary mb-2 mt-2" >
                                <img src="/svgs/doc-thing.svg" style="margin-inline:8px;"/>
                                تحديد الخدمة الطبية
                            </div>

                            <div class="row justify-content-around">
                                <div class="mb-3 col-md-5">
                                    <label for="email" class="form-label">البريد الالكتروني </label>
                                    <select class="form-control" id="email">
                                        <option value="ab">do do</option>
                                    </select>
                                </div>



                                <div class="mb-3 col-md-5">
                                    <label for="password" class="form-label">كلمة المرور </label>
                                    <select class="form-control" id="password">
                                        <option value="ab">do do</option>
                                    </select>
                                </div>
                            </div>

                            <div class="flex text-primary mb-2 mt-2 " >
                                <img src="/svgs/date-out.svg" style="margin-inline:8px;"/>
                                الموعد المقترح
                            </div>

                            <div class="row justify-content-around">

                                <div class="mb-3 col-md-5">
                                    <label for="myDate" class="form-label">البريد الالكتروني </label>
                                    <input  type="date" class="form-control" id="myDate">

                                    <div class="note mt-4 text-secondary flex">
                                        <img src="./svgs/info.svg" alt="icon" />
                                        المواعيد تخضع للتأكيد النهائي من خلال اتصال قسم المواعيد بكم.
                                    </div>

                                </div>


                                <div class="mb-3 col-md-5">
                                    <label for="password" class="form-label">كلمة المرور </label>
                                    <div class="row justify-content-between">
                                        <div class="time-slot col-md-5 time-slot-active mb-3">
                                            19:00 ص
                                        </div>

                                        <div class="time-slot col-md-5 mb-3">
                                            19:00 ص
                                        </div>

                                        <div class="time-slot col-md-5 mb-3">
                                            19:00 ص
                                        </div>

                                        <div class="time-slot col-md-5 mb-3">
                                            19:00 ص
                                        </div>


                                    </div>
                                </div>

                                <div class="mb-3 mt-3">
                                    <label for="message" class="form-label text-primary">ملاحظات طبية إضافية</label>
                                    <textarea class="form-control" id="message" rows="5" placeholder="يرجى كتابة أي ملاحظات أو استفسارات طبية ترغب في مشاركتها مع الطبيب..."></textarea>
                                </div>
                            </div>

                            <div class="row mb-5 mt-5 justify-content-around">
                                <p class="text-secondary col-md-5">
                                    بتقديم هذا الطلب، فإنك توافق على سياسة الخصوصية الخاصة
                                    <br>
                                    بالمركز الطبي واستخدام بياناتك لأغراض جدولة المواعيد.
                                </p>
                                <button type="submit" class="btn-primary col-md-4"  >  تأكيد طلب الحجز
                                    <img src="./svgs/appointment.svg" alt="icon" style="margin-right: 16px;">
                                </button>
                            </div>
                        </form>
                    </div>
                </section>
                <section class="row justify-content-around features-section">

                    <div class="flex-column  col-md-3 ">
                        <div class="feature-icon mb-4">
                            <img src="/svgs/certification.svg" alt="icon"/>
                        </div>

                        <h4 class="text-primary">شهادات عالمية</h4>
                        <p class="text-secondary">معايير جودة طبية تتوافق مع البروتوكولات العالمية
                        </p>
                    </div>
                    <div class="flex-column  col-md-3 text-center ">
                        <div class="feature-icon mb-4">
                            <img src="/svgs/privacy.svg" alt="icon"/>
                        </div>
                        <h4 class="text-primary"> خصوصية تامة</h4>
                        <p class="text-secondary">بياناتكم الطبية مشفرة ومحفوظة بأعلى درجات السرية
                        </p>
                    </div>
                    <div class="flex-column  col-md-3 ">
                        <div class="feature-icon mb-4">
                            <img src="/svgs/support.svg" alt="icon"/>
                        </div>

                        <h4 class="text-primary"> دعم متواصل</h4>
                        <p class="text-secondary">
                            فريق التنسيق الطبي متاح للإجابة على اتصالاتكم
                        </p>
                    </div>
                </section>

            </div>
            <%@ include file="shared/footer.jsp" %>
            <script src="./js/bootstrap.min.js"></script>
        </body>
    </html>
