<!DOCTYPE html>
<html lang="en">
<head>
    <title>DBH Containers</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="formTemplate/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/vendor/noui/nouislider.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="formTemplate/css/util.css">
	<link rel="stylesheet" type="text/css" href="formTemplate/css/main.css">
<!--===============================================================================================-->
</head>
<body>


	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form" action="insert_depot.php" method="get">
				<span class="contact100-form-title">
					Ajouter Un Depot
				</span>


				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate = "Veuillez Entrer Nombres de Places	">
					<span class="label-input100">Nombres de Places *</span>
					<input class="input100" type="text" name="nbPlace" placeholder="Nombres de Places ">
				</div>

				<div class="wrap-input100 bg1 rs1-wrap-input100" data-validate = "Veuillez Entrer Adresse">
					<span class="label-input100">Adresse *</span>
					<input class="input100" type="text" name="adresse" placeholder="Adresse">
				</div>
				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate = "Veuillez Entrer La Ville">
					<span class="label-input100">Ville *</span>
					<input class="input100" type="text" name="ville" placeholder="Ville ">
				</div>
				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate = "Veuillez Entrer Le CodePostal">
					<span class="label-input100">CodePostal *</span>
					<input class="input100" type="text" name="codePostal" placeholder="CodePostal ">
				</div>
				
		
		

			
				</div>

			

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn" name="save" value="save">
						<span>
							Submit
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>
	



<!--===============================================================================================-->
	<script src="formTemplate/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="formTemplate/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="formTemplate/vendor/bootstrap/js/popper.js"></script>
	<script src="formTemplate/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="formTemplate/vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});


			$(".js-select2").each(function(){
				$(this).on('select2:close', function (e){
					if($(this).val() == "Please chooses") {
						$('.js-show-service').slideUp();
					}
					else {
						$('.js-show-service').slideUp();
						$('.js-show-service').slideDown();
					}
				});
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="formTemplate/vendor/daterangepicker/moment.min.js"></script>
	<script src="formTemplate/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="formTemplate/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="formTemplate/vendor/noui/nouislider.min.js"></script>
	<script>
	    var filterBar = document.getElementById('filter-bar');

	    noUiSlider.create(filterBar, {
	        start: [ 1500, 3900 ],
	        connect: true,
	        range: {
	            'min': 1500,
	            'max': 7500
	        }
	    });

	    var skipValues = [
	    document.getElementById('value-lower'),
	    document.getElementById('value-upper')
	    ];

	    filterBar.noUiSlider.on('update', function( values, handle ) {
	        skipValues[handle].innerHTML = Math.round(values[handle]);
	        $('.contact100-form-range-value input[name="from-value"]').val($('#value-lower').html());
	        $('.contact100-form-range-value input[name="to-value"]').val($('#value-upper').html());
	    });
	</script>
<!--===============================================================================================-->
	<script src="formTemplate/js/main.js"></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>

</body>
</html>