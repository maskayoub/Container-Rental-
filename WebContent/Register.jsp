<!DOCTYPE html>
<html lang="en">
<head>
    <title>DBH Containers</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="logintemplate/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="logintemplate/css/style.css">
</head>
<body>

    <div class="main">


                <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Inscription</h2>
			    		<form action="subscribe.php" method="post">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="first_name" id="first_name" placeholder="Prénom"/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="last_name" id="last_name" placeholder="Nom"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Email"/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="adresse" id="adresse" placeholder="Adresse"/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="fax" id="fax" placeholder="Fax"/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="tel" id="tel" placeholder="Tel"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="password" placeholder="Mot de passe"/>
                            </div>
                            <div class="form-group">
                                <label for="password_confirmation"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="password_confirmation" id="password_confirmation" placeholder="Répéter mot de passe"/>
                            </div>

                            <div class="form-group form-button">
                                <input type="submit" name="register" id="register" class="form-submit" value="register"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="logintemplate/images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="Login.jsp" class="signup-image-link">Déjà membre ? Se connecter</a>
                    </div>
                </div>
            </div>
        </section>

        



    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>