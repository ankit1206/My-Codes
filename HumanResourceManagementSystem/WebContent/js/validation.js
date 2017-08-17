/**
 * 
 */
function validateRegister() {
	$("#message").hide();
	var val = true;
	var alphaExp = /^[a-zA-Z]+$/;
	if (document.regform.name.value.length == 0
			|| document.regform.name.value == null) {
		$("#nameError").show();
		document.getElementById("nameError").innerHTML = "* Name cannot be Empty";
		val = false;
	} else {
		if (document.regform.name.value.match(alphaExp)) {
			$("#nameError").hide();
		} else {
			$("#nameError").show();
			document.getElementById("nameError").innerHTML = "* Name Should contain only alphabet";

			val = false;
		}

	}

	if (document.getElementById("male").checked) {
		$("#GenderError").hide();
	} else if (document.getElementById("female").checked) {
		$("#GenderError").hide();
	} else {
		$("#GenderError").show();
		document.getElementById("GenderError").innerHTML = "* Select a Gender";
		val = false;

	}

	if (document.regform.dob.value.length == 0
			|| document.regform.dob.value == null) {
		$("#dobError").show();
		document.getElementById("dobError").innerHTML = "* Enter the Date of Birth";
		val = false;
	} else {
		$("#dobError").hide();
	}

	if (document.regform.doj.value.length == 0
			|| document.regform.doj.value == null) {
		$("#dojError").show();
		document.getElementById("dojError").innerHTML = "* Enter the date of joining";
		val = false;
	} else {
		$("#dojError").hide();
	}

	if (document.regform.contactno.value.length == 0
			|| document.regform.contactno.value == null) {
		$("#contactnoError").show();
		document.getElementById("contactnoError").innerHTML = "* Enter the contact no";
		val = false;
	} else {
		$("#contactnoError").hide();
	}

	var numericExpression = /^[0-9]{10}$/;
	if (document.regform.contactno.value.match(numericExpression)) {
		$("#contactnoError").hide();
	} else {
		$("#contactnoError").show();
		document.getElementById("contactnoError").innerHTML = "* Contact No should be of 10 digits";
		val = false;
	}

	if (document.regform.bankac.value.length == 0
			|| document.regform.bankac.value == null) {
		$("#bankacError").show();
		document.getElementById("bankacError").innerHTML = "* Enter the Bank account no";
		val = false;
	} else {
		$("#bankacError").hide();
	}

	var panFormat = /^[A-Z]{5}\d{4}[A-Z]{1}$/;

	if (document.regform.panno.value.length == 0
			|| document.regform.panno.value == null) {
		$("#pannoError").show();
		document.getElementById("pannoError").innerHTML = "* Enter PAN no";
		val = false;
	} else {
		if (document.regform.panno.value.match(panFormat)) {
			$("#pannoError").hide();

		} else {

			$("#pannoError").show();
			document.getElementById("pannoError").innerHTML = "* Enter Pan no in valid format";

			val = false;
		}
	}
	if (document.regform.email.value.length == 0
			|| document.regform.email.value == null) {
		$("#emailError").show();
		document.getElementById("emailError").innerHTML = "* Enter the Email ID";
		val = false;
	} else {
		$("#emailError").hide();
	}
	var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	if (document.regform.email.value.match(emailExp)) {
		$("#emailError").hide();
	} else {
		$("#emailError").show();
		document.getElementById("emailError").innerHTML = "* Enter the Email in valid format";
		val = false;
	}
	if (document.regform.address.value.length == 0
			|| document.regform.address.value == null) {
		$("#addressError").show();
		document.getElementById("addressError").innerHTML = "* Enter the Address";
		val = false;
	} else {
		$("#addressError").hide();
	}

	if (document.regform.country.value == '-1') {
		$("#countryError").show();
		document.getElementById("countryError").innerHTML = "* Select country";
		val = false;
	} else {
		$("#countryError").hide();
	}
	if (document.regform.state.value == '-1') {
		$("#stateError").show();
		document.getElementById("stateError").innerHTML = "* Select state";
		val = false;
	} else {
		$("#stateError").hide();
	}
	if (document.regform.designation.value == 'Select') {
		$("#designationError").show();
		document.getElementById("designationError").innerHTML = "* Select designation";
		val = false;
	} else {
		$("#designationError").hide();
	}
	if (document.regform.domain.value.length == 0
			|| document.regform.domain.value == null) {
		$("#domainError").show();
		document.getElementById("domainError").innerHTML = "* Enter the domain";
		val = false;
	} else {
		$("#domainError").hide();
	}

	var salaryFormat = /^[0-9]+(\.?[0-9]+)?$/;

	if (document.regform.salary.value.length == 0
			|| document.regform.salary.value == null) {
		$("#salaryError").show();
		document.getElementById("salaryError").innerHTML = "* Enter the salary";
		val = false;
	} else {
		if (document.regform.salary.value.match(salaryFormat)) {
			$("#salaryError").hide();
		} else {
			$("#salaryError").show();
			document.getElementById("salaryError").innerHTML = "* Salary should be a number";

			val = false;
		}
	}
	return val;
}

function reset() {
	$("#nameError").hide();
	$("#GenderError").hide();
	$("#dobError").hide();
	$("#dojError").hide();
	$("#contactnoError").hide();
	$("#bankacError").hide();
	$("#pannoError").hide();
	$("#emailError").hide();
	$("#addressError").hide();
	$("#countryError").hide();
	$("#stateError").hide();
	$("#designationError").hide();
	$("#domainError").hide();
	$("#salaryError").hide();
	return false;
}

function validateConveyance() {
	var flag = true;
	// var empId = document.forms["Conveyance"]["employeeId"].value;
	var from = document.forms["Conveyance"]["source"].value;
	var docDate = document.forms["Conveyance"]["documentDate"].value;
	var to = document.forms["Conveyance"]["destination"].value;
	var particulars = document.forms["Conveyance"]["particulars"].value;
	var noOfDays = document.forms["Conveyance"]["noOfDays"].value;
	var modeOfTravel = document.forms["Conveyance"]["modeOfTravel"].value;
	var distance = document.forms["Conveyance"]["distance"].value;
	var amount = document.forms["Conveyance"]["amount"].value;

	if (distance.length > 1) {
		$("#distanceerror").hide();
	}
	if (amount.length > 1) {
		$("#amounterror").hide();
	}
	if (particulars.length > 1) {
		$("#parterror").hide();
	}
	if (noOfDays.length > 1) {
		$("#noderror").hide();
	}
	if (modeOfTravel.length > 1) {
		$("#moterror").hide();
	}
	if (from.length > 1) {
		$("#fromerror").hide();
	}
	if (docDate.length > 1) {
		$("#docDateerror").hide();
	}
	if (to.length > 1) {
		$("#toerror").hide();
	}

	if (from == null || from.length < 1) {
		$("#fromerror").show();
		document.getElementById("fromerror").innerHTML = "* Source location cannot be empty";
		flag = false;
	}
	if (to == null || to.length < 1) {
		$("#toerror").show();
		document.getElementById("toerror").innerHTML = "* Destination location cannot be empty";
		flag = false;
	}
	if (docDate == null || docDate.length < 1) {
		$("#docDateerror").show();
		document.getElementById("docDateerror").innerHTML = "* Document Date cannot be empty";
		flag = false;
	}
	if ("select" == modeOfTravel) {
		$("#moterror").show();
		document.getElementById("moterror").innerHTML = "* Mode Of Travel cannot be empty";
		flag = false;
	}
	if (noOfDays == null || noOfDays.length < 1) {
		$("#noderror").show();
		document.getElementById("noderror").innerHTML = "* No Of Days cannot be empty";
		flag = false;
	}
	if (particulars == null || particulars.length < 1) {
		$("#parterror").show();
		document.getElementById("parterror").innerHTML = "* Particulars cannot be empty";
		flag = false;
	}
	if (amount == null || amount.length < 1) {
		$("#amounterror").show();
		document.getElementById("amounterror").innerHTML = "* Amount cannot be empty";
		flag = false;
	}
	if (distance == null || distance.length < 1) {
		$("#distanceerror").show();
		document.getElementById("distanceerror").innerHTML = "* Distance cannot be empty";
		flag = false;
	} else if (distance <= 40) {
		$("#distanceerror").show();
		document.getElementById("distanceerror").innerHTML = "* Distance cannot be less than 40";
		flag = false;
	}

	if (noOfDays >= 30) {
		$("#noderror").show();
		document.getElementById("noderror").innerHTML = "* No Of Days must be less than 30";
		flag = false;
	}
	return flag;
}

function validateAppraisal() {
	var flag = true;
	// var empId = document.forms["Conveyance"]["employeeId"].value;

	var projectName = document.forms["Appraisal"]["projName"].value;
	var projectSdate = document.forms["Appraisal"]["projSdate"].value;
	var testingReport = document.forms["Appraisal"]["testReport"].value;
	var certName = document.forms["Appraisal"]["certName"].value;
	var certDate = document.forms["Appraisal"]["certDate"].value;

	if (projectName.length > 1) {
		$("#pnameerror").hide();
	}
	if (projectSdate.length > 1) {
		$("#psdateerror").hide();
	}
	if (testingReport.length > 1) {
		$("#treporterror").hide();
	}
	if (certName.length > 1) {
		$("#cnameerror").hide();
	}
	if (certDate.length > 1) {
		$("#cdateerror").hide();
	}

	var format = /^[a-zA-Z]+$/;
	if (projectName == null || projectName.length < 1) {
		$("#pnameerror").show();
		document.getElementById("pnameerror").innerHTML = "* Project name cannot be empty";
		flag = false;
	}

	else {
		if (document.Appraisal.projName.value.match(format)) {
			$("#pnameerror").hide();
		} else {
			$("#pnameerror").show();
			document.getElementById("pnameerror").innerHTML = "* Name Should contain only alphabet";

			flag = false;
		}
	}
	if (projectSdate == null || projectSdate.length < 1) {
		$("#psdateerror").show();
		document.getElementById("psdateerror").innerHTML = "* Project Start Date location cannot be empty";
		flag = false;
	}
	if (testingReport == null || testingReport.length < 1) {
		$("#treporterror").show();
		document.getElementById("treporterror").innerHTML = "* Testing Report cannot be empty";
		flag = false;
	} else if ((testingReport >= 0 && testingReport < 40)
			|| testingReport > 100) {
		$("#treporterror").show();
		document.getElementById("treporterror").innerHTML = "* Testing Report should be between 40 and 100";
		flag = false;
	}
	if (certName == null || certName.length < 1) {
		$("#cnameerror").show();
		document.getElementById("cnameerror").innerHTML = "* Certificate Name cannot be empty";
		flag = false;
	}
	if (certDate == null || certDate.length < 1) {
		$("#cdateerror").show();
		document.getElementById("cdateerror").innerHTML = "* Certificate Date cannot be empty";
		flag = false;
	}

	return flag;
}