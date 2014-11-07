<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sentence Parser</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<style>
body {
	margin-top:20px;
	margin-right:70px;
	margin-bottom:10px;
	margin-left:70px;
}
</style>
<link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap-responsive.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/css/bootstrap-select.min.css"	rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/js/bootstrap-select.min.js"></script>
</head>
<body>

	<ul class="nav nav-tabs" role="tablist">
		<li class="active"><a href="home">Home</a></li>
		<li><a href="parser">Parser</a></li>
	</ul>

	<div align='center'>
		<h2>
			Sentence Parser<br> <br>
		</h2>
	</div>

	<form id="form">
		<div id="sentences">
			<div id="sentence" class="input-group">
				<span class="input-group-btn">
					<button id="rmSentenceBtn" class="btn btn-danger" type="button">
						<span class="glyphicon glyphicon-minus"></span>
					</button>
				</span>
				<span id="rmBtnNth" class="input-group-btn">
					<button id="nth" class="btn btn-default" type="button">1
					</button>
				</span>
  				<span id="questionType" class="input-group-addon"> 
					<select	name="questionType" class="btn btn-default">
						<option value="what">What</option>
						<option value="when">When</option>
						<option value="where">Where</option>
					</select>
				</span>
				<input type="text" id="inputSentence" name="inputSentence" 
					class="form-control" placeholder="input sentence">
				<span id="if" class="input-group-addon">IF</span>
				<input type="text" id="ifSentence" name="ifSentence"
					class="form-control" placeholder="input sentence">
				<span id="then" class="input-group-addon">THEN</span>
				<input type="text" id="thenSentence" name="thenSentence"
					class="form-control" placeholder="input sentence">
				<span id="questionMark" class="input-group-addon">?</span>
				
				<span class="input-group-addon"> 
					<select id="exception" name="exception" class="btn btn-default">
						<option value="exception">Exception</option>
					</select>
				</span>
				<span class="input-group-addon"> 
					<select id="sentenceAttr" name="sentenceAttr" class="btn btn-default">
						<option value="strict">Strict</option>
						<option value="defeasible">Defeasible</option>
					</select>
				</span>
				<span class="input-group-addon"> 
					<select id="sentenceType" name="sentenceType" class="btn btn-default">
						<option value="sentence">Sentence</option>
						<option value="rule">Rule</option>
						<option value="question">Question</option>
					</select>
				</span>
				
				<select class="selectpicker" multiple title='except w.' name="except[]" data-width="100px">
					<option value="1">1</option>
				</select>
			</div>
		</div>
		<br>
		<div align='center'>
			<button id="addSentenceBtn" class="btn btn-primary btn-pad"
				type="button">Add Sentence</button>
			<button id="parseBtn" class="btn btn-primary btn-pad" type="submit"
				name="submit" value="true">Parse</button>
		</div>
	</form>
	<br>
	<br>
	<c:if test="${not empty model.sentences}">
		<c:forEach var="sentence" items="${model.sentences}">
		<div id="inputSentence" class="input-group">
			<span class="input-group-btn">
				<button id="nth" class="btn btn-warning" type="button">${sentence.num}</button>
			</span> <input type="text" id="inputSentence" name="inputSentence"
				class="form-control" value="${sentence.sentence}"
				readonly="readonly">
				<c:if test="${sentence.exception ne 'exception'}">
				<span class="input-group-btn">
				<button class="btn btn-info">Exception With</button>
				<button id="nth" class="btn btn-warning" type="button">${sentence.exception}</button>
			</span></c:if>
		</div>
		</c:forEach>
	</c:if>
	<br>
	<br>
	<c:if test="${not empty model.sentences}">
		<div id=drs class="input-group">
			<span class="input-group-btn">
				<button class="btn btn-success">DRS</button>
			</span> <input type="text" id="drs" name="drs" class="form-control"
				value="${model.sentences[0].drs}" readonly="readonly">
		</div>
	</c:if>
	<br>
	<br>
	<c:if test="${not empty model.sentences}">
		<div id=fol class="input-group">
			<span class="input-group-btn">
				<button class="btn btn-success">FOL</button>
			</span> <input type="text" id="fol" name="fol" class="form-control"
				value="${model.sentences[0].fol}" readonly="readonly">
		</div>
	</c:if>
	<script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script>
		// if cannot update the data in the exception select, try removing the exception select and create a new one with correct options.
		var num = 1;
		$(document).ready(function() {
			$("input#ifSentence").hide();
			$("input#thenSentence").hide();
			$("span#if").hide();
			$("span#then").hide();
			$("span#questionType").hide();
			$("span#questionMark").hide();
			$('#form').on('change', 'select#sentenceType', function(){
				if ($(this).val().localeCompare("sentence") == 0) {
					$(this).parent().parent().children("#inputSentence").show();
					$(this).parent().parent().children("#ifSentence").hide();
					$(this).parent().parent().children("#thenSentence").hide();
					$(this).parent().parent().children("#if").hide();
					$(this).parent().parent().children("#then").hide();
					$(this).parent().parent().children("#questionMark").hide();
					$(this).parent().parent().children("#questionType").hide();
				} else if ($(this).val().localeCompare("rule") == 0) {
					$(this).parent().parent().children("#inputSentence").hide();
					$(this).parent().parent().children("#ifSentence").show();
					$(this).parent().parent().children("#thenSentence").show();
					$(this).parent().parent().children("#if").show();
					$(this).parent().parent().children("#then").show();
					$(this).parent().parent().children("#questionMark").hide();
					$(this).parent().parent().children("#questionType").hide();
				} else if ($(this).val().localeCompare("question") == 0) {
					$(this).parent().parent().children("#inputSentence").show();
					$(this).parent().parent().children("#ifSentence").hide();
					$(this).parent().parent().children("#thenSentence").hide();
					$(this).parent().parent().children("#if").hide();
					$(this).parent().parent().children("#then").hide();
					$(this).parent().parent().children("#questionMark").show();
					$(this).parent().parent().children("#questionType").show();
				}
			});
			
			$('#form').on('click', '#addSentenceBtn', function() {
				num = num + 1;
				var sentenceDiv = $("#sentence:last").clone(true);
				sentenceDiv.children("#inputSentence").removeAttr("value");
				sentenceDiv.children("#rmBtnNth").children("#nth").remove();
				sentenceDiv.children("#rmBtnNth").append('<button id="nth" class="btn btn-default" type="button">'
						+ num + '</button>');
				$("#sentences").append(sentenceDiv);
			
				$("select#exception").children().remove();
				$("select#exception").append('<option value="exception">Exception</option>');
				for (var i = 1; i <= num; i++) {
					$("select#exception").append('<option value="' + i +'">' + i + '</option>');
				}
				
				//process multiselect
				var exceptToRemove = $(".selectpicker");
				exceptToRemove.remove();
				$(".bootstrap-select").remove();
				
				var exception = '<select class="selectpicker" multiple title="except w." name="except[]" data-width="100px">';
				for (var i = 1; i <= num; i++) {
					exception += '<option value="' + i +'">' + i + '</option>';
				}
				exception += '</select>';
				$("div#sentence").append(exception);
				 
				$('.selectpicker').selectpicker({
				      style: 'btn-defalut',
				      size: 4
				});
				
			});

			$("#rmSentenceBtn").click(function() {
				if (num == 1) {
					return;
				}
				$(this).parent().parent().remove();
				num = num - 1;
				$("select#exception").children().remove();
				$("select#exception").append('<option value="exception">exception</option>');
				for (var i = 1; i <= num; i++) {
					$("select#exception").append('<option value="' + i +'">' + i + '</option>');
					$("span#rmBtnNth").children("#nth").remove();
				}
				for (var i = 1; i <= num; i++) {
					$("div#sentence:nth-child(" + i + ")").children("#rmBtnNth").append('<button id="nth" class="btn btn-default" type="button">'
							+ i + '</button>');
				}
				
				$(".selectpicker").remove();
				$(".bootstrap-select").remove();
				
				var exception = '<select class="selectpicker" multiple title="except w." name="except[]" data-width="100px">';
				for (var i = 1; i <= num; i++) {
					exception += '<option value="' + i +'">' + i + '</option>';
				}
				exception += '</select>';
				$("div#sentence").append(exception);
				 
				$('.selectpicker').selectpicker({
				      style: 'btn-defalut',
				      size: 4
				});
			});
			
			$('.selectpicker').selectpicker({
			      style: 'btn-defalut',
			      size: 4
			});
		});
	</script>
</body>
</html>
