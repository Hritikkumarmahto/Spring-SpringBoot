<%-- 
    Document   : SIGNUP
    Created on : 07-Jan-2025, 4:51:47 pm
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    </head>
    <body>
        <div class="container">
            <div class="row>
                 <div class="col" m6 offset-m3>
                <div class="card">
                    <div class="card-content center-align">
                        <h3>Register Here !</h3>  
                        <h5 id="msg" style="color: green; display:none;"></h5>
                        <div class="form center-align">
                            <form action="Register" method="post" id="myForm">
                                <input type="text" name="user_name" placeholder="Enter user name">
                                <input type="email" name="user_email" placeholder="Enter user email">
                                <input type="Password" name="user_password" placeholder="Enter password">
                                
                                    <div class="file-field input-field">
                                        <div class="btn">
                                            <span>File</span>
                                            <input name="image" type="file">
                                        </div>
                                        <div class="file-path-wrapper">
                                            <input class="file-path validate" type="text">
                                        </div>
                                    </div>
                                
                                <button type="submit" class="btn">Submit</button>
                            </form>
                        </div>
                    </div>
                    <div class="Loader center-align" style="margin-top:10px; display:none;">
                        <div class="preloader-wrapper big active">
                            <div class="spinner-layer spinner-blue-only">
                                <div class="circle-clipper left">
                                    <div class="circle"></div>
                                </div><div class="gap-patch">
                                    <div class="circle"></div>
                                </div><div class="circle-clipper right">
                                    <div class="circle"></div>
                                </div>
                            </div>
                        </div>
                        <h5>Please wait...</h5>
                    </div>

                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

        <script>
            $(document).ready(function () {
                console.log("this page is ready");
                $("#myForm").on('submit', function (event) {
                    event.preventDefault();
//                    var f = $(this).serialize(); this is only used in for textr data 
                    let f=new FormData(this);   
                    console.log(f);
                    $(".Loader").show();
                    $(".form").hide();
                    $.ajax({
                        url: "Register",
                        data: f,
                        type: 'POST',
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
//                            console.log("success....");
                            $(".Loader").hide();
                            $(".form").show();
                            if (data.trim() === 'done') {
                                $('#msg').html("Sucessfully registered ");
//                                 $("#msg").show();

                            } else {
                                $('#msg').html("Somthing went wrong ")
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            console.log(jqXHR);
                            console.log("error");
                            $(".Loader").hide();
                            $(".form").show();
                        }
                        processeData:false,
                        contentType:false
                    });
                });
            });


        </script>   
    </body>
</html>
