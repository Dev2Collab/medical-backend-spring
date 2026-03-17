<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Contact us </title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./style.css">
        <link rel="stylesheet" href="./css/contact.css">
    </head>
    <body>
        <div class="container">
            <%@ include file="shared/header.jsp" %>
        </div>
        <section class="section-one">
            <div class="container ">
                <div>
                    <p class="btn-gold ">تأسست لترتقي بتجربتك الصحية</p>
                    <h1 class="text-primary">تواصل مع فريقنا الطبي </h1>
                    <p class="text-secondary">نسعد بالإجابة على استفساراتكم الطبية ومساعدتكم في حجز المواعيد. فريقنا جاهز
                        لخدمتكم على مدار الساعة بمهنية واحترافية.
                    </p>
                </div>
            </div>
        </section>
        <section class="section-two row justify-content-between">
            <div class="col-md-5">
                <form >
                    <h2 class="text-primary">أرسل لنا رسالة</h2>
                    <p class="text-secondary">سنقوم بالرد عليك في أقرب وقت ممكن عبر بريدك الإلكتروني.</p>
                    <div class="form-group row">

                        <div class="mb-3 col" >
                            <label for="fullName" class="form-label text-primary">الاسم بالكامل</label>
                            <div  class="input-holder">
                                <input type="text" class="form-control" id="fullName" placeholder="ادخل اسمك ">
                                <span>   <img src="./svgs/at_mark.svg" alt="email icon">
                                </span>
                            </div>
                        </div>

                        <div class="mb-3 col" >
                            <label for="email" class="form-label text-primary">البريد الالكتروني </label>
                            <div  class="input-holder">
                                <input  type="email" class="form-control" id="email" placeholder="hema@example.com">
                                <span>   <img src="./svgs/at_mark.svg" alt="email icon">
                                </span>
                            </div>
                        </div>

                        <div class="mb-3 " >
                            <label for="subject" class="form-label text-primary">الموضوع </label>
                            <div  class="input-holder">
                                <input  type="email" class="form-control" id="subject" placeholder="موضوع الرساله ">
                                <span>   <img src="./svgs/at_mark.svg" alt="email icon">
                                </span>
                            </div>
                        </div>

                    </div>

                    <div class="mb-3">
                        <label for="message" class="form-label text-primary">الرسالة</label>
                        <textarea class="form-control" id="message" rows="5" placeholder="اكتب تفاصيل استفسارك هنا "></textarea>
                    </div>
                    <button type="submit" class="btn-green col-md-5" > إرسال الرسالة
                        <img src="./svgs/send.svg" alt="icon" style="margin-right: 16px;">
                    </button>
                </form>
            </div>
            <div class="col-md-5">

                <div class="row justify-content-between">
                    <div class="gray-card col-md-5">
                        <div class="col-md-5 flex">
                            <p class="btn-square-gold">
                                <img src="/svgs/location.svg" alt="icon" />
                            </p>
                        </div>
                        <h4 class="text-primary"> العنوان
                        </h4>
                        <p class="text-secondary">
                            شارع الملك فهد، حي الصحافة
                            الرياض، المملكة العربية السعودية
                        </p>
                    </div>
                    <div class="gray-card col-md-5">
                        <div class="col-md-5 flex">
                            <p class="btn-square-gold">
                                <img src="/svgs/call.svg" alt="icon" />
                            </p>
                        </div>
                        <h4 class="text-primary"> أرقام التواصل
                        </h4>
                        <p class="text-secondary ltr" >
                            +966 11 234 5678
                            <br>
                            +966 50 123 4567
                        </p>
                    </div>
                </div>

                <div class="gray-card row mt-3">
                    <div class=" row justify-content-between">
                        <div class="col-md-5 flex">
                            <p class="btn-square-gold">
                                <img src="/svgs/clock.svg" alt="icon" />
                            </p>
                        </div>

                        <div class="col-md-5 flex-l">
                            <p class="btn-gold ">
                                مفتوح الآن
                            </p>
                        </div>

                    </div>
                    <h4 class="text-primary"> ساعات العمل
                    </h4>
                    <div class="row justify-content-between">
                        <div class="col-md-5">
                            <h5 class="text-primary">السبت - الخميس
                            </h5>
                            <p class="text-secondary">
                                9:00 صباحاً - 9:00 مساءً
                            </p>
                        </div>
                        <div class="col-md-5">
                            <h5 class="text-primary"> الجمعة
                            </h5>
                            <p class="text-secondary">
                                4:00 مساءً - 9:00 مساءً
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@ include file="shared/footer.jsp" %>
        <script src="./js/bootstrap.min.js"></script>
    </body>
</html>
