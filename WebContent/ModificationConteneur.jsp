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
			<form class="contact100-form validate-form" action="update_conteneur.php" method="get">
				<span class="contact100-form-title">
					Confirmation Du Changement
				</span>

				<div class="wrap-input100 validate-input bg1">
					<span class="label-input100">ID *</span>
					<input class="input100" type="text" name="id" value=${model.c.id} readonly="readonly">
				</div>
				<div class="wrap-input100 validate-input bg1" data-validate="Veuillez Entrer L'ID Du Conteneur">
					<span class="label-input100">ID Depot *</span>
					<input class="input100" type="text" name="id_depot" value=${model.c.id_depot}>
				</div>

				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100">
					<span class="label-input100">Type *</span>
					<input class="input100" type="text"   name="type" value=${model.c.type}>
				</div>

				<div class="wrap-input100 bg1 rs1-wrap-input100">
					<span class="label-input100">Largeur *</span>
					<input class="input100" type="text"  name="largeur" value=${model.c.largeur}>
				</div>
				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100">
					<span class="label-input100">Hauteur *</span>
					<input class="input100" type="text"  name="hauteur" value=${model.c.hauteur}>
				</div>
				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100" >
					<span class="label-input100">Longueur *</span>
					<input class="input100" type="text" name="longueur" value=${model.c.longueur}>
				</div>
				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100">
					<span class="label-input100">Largeur Porte *</span>
					<input class="input100" type="text" name="largeur_porte" value=${model.c.largeur_porte}>
				</div>
				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100">
					<span class="label-input100">Longueur Porte *</span>
					<input class="input100" type="text" name="longueur_porte" value=${model.c.longueur_porte}>
				</div>
				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100">
					<span class="label-input100">Hauteur Porte *</span>
					<input class="input100" type="text" name="hauteur_porte" value=${model.c.hauteur_porte}>
				</div>
				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100">
					<span class="label-input100">Poids *</span>
					<input class="input100" type="text" name="Poids" value=${model.c.poids}>
				</div>
				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100" >
					<span class="label-input100">Capacité *</span>
					<input class="input100" type="text" name="Capacite" value=${model.c.capacite}>
				</div>
		
					<div class="wrap-input100 validate-input bg1 rs1-wrap-input100">
					<span class="label-input100">Prix *</span>
					<input class="input100" type="text" name="Prix" value=${model.c.prix}>
				</div>

			
				</div>

			

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn" name ="modifier"  value="updateit" onclick="return confirm('Êtes-vous sûr de bien vouloir modifier cet élément?');">
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
