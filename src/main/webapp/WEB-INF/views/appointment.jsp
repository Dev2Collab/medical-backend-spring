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
                            <div class="flex text-primary" >
                                <img src="/svgs/book-person.svg" style="margin-inline:8px;"/>
                                البيانات الشخصية للمريض
                            </div>

                            <div class="row  flex-between">
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


                            <div class="flex text-primary" >
                                <img src="/svgs/doc-thing.svg" style="margin-inline:8px;"/>
                               تحديد الخدمة الطبية
                            </div>

                            <div class="row">
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

                            <div class="flex text-primary" >
                                <img src="/svgs/date-out.svg" style="margin-inline:8px;"/>
                              الموعد المقترح
                            </div>

                            <div class="row">
                                <div class="mb-3 col-md-5">
                                    <label for="myDate" class="form-label">البريد الالكتروني </label>
                                    <input  type="date" class="form-control" id="myDate">

                                </div>



                                <div class="mb-3 col-md-5">
                                    <label for="password" class="form-label">كلمة المرور </label>
                                    <select class="form-control" id="password">
                                        <option value="ab">do do</option>
                                    </select>
                                </div>

                                <div class="mb-3 mt-3">
                                    <label for="message" class="form-label text-primary">الرسالة</label>
                                    <textarea class="form-control" id="message" rows="5" placeholder="اكتب تفاصيل استفسارك هنا "></textarea>
                                </div>
                            </div>

                            <%-- //TODO COMPLETE THE FORM UI  --%>
                            <button type="submit" class="btn-signup" >  انشاء الحساب
                                <img src="./svgs/arrow-left.svg" alt="icon" style="margin-right: 16px;">
                            </button>
                        </form>
                        <%-- //TODO ADD THE THREE CARDS FROM THE DESIGN  --%>
                    </div>
                </section>
            </div>
            <%@ include file="shared/footer.jsp" %>
            <script src="./js/bootstrap.min.js"></script>
        </body>
    </html>
