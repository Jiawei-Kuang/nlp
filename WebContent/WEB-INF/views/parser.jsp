<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sentence Parser</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	
}
</style>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap-responsive.css"
	rel="stylesheet">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
	
</script>
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
				<span id="rmBtnNth" class="input-group-btn">
					<button id="rmSentenceBtn" class="btn btn-primary" type="button">Remove
					</button>
					<button id="nth" class="btn btn-warning" type="button">1
					</button>
				</span> <input type="text" id="inputSentence" name="inputSentence"
					class="form-control" placeholder="input sentence"> <span
					class="input-group-btn"> <select id="exception"
					name="exception" class="btn btn-default dropdown-toggle">
						<option value="exception">Exception</option>

				</select>
				</span>
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
	<c:if test="${not empty sentences}">
		<c:forEach var="sentence" items="${sentences}">
		<div id="inputSentence" class="input-group">
			<span class="input-group-btn">
				<button class="btn btn-success">Input Sentence</button>
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
	<c:if test="${not empty sentences}">
		<div id=drs class="input-group">
			<span class="input-group-btn">
				<button class="btn btn-success">DRS</button>
			</span> <input type="text" id="drs" name="drs" class="form-control"
				value="${sentences[0].drs}" readonly="readonly">
		</div>
	</c:if>
	<br>
	<br>
	<c:if test="${not empty sentences}">
		<div id=fol class="input-group">
			<span class="input-group-btn">
				<button class="btn btn-success">FOL</button>
			</span> <input type="text" id="fol" name="fol" class="form-control"
				value="${sentences[0].fol}" readonly="readonly">
		</div>
	</c:if>

	<script
		src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script>
	var num = 1;
	$(document).ready(function() {
		$('#form').on('click', '#addSentenceBtn', function() {
			num = num + 1;
			var sentenceDiv = $("#sentence:last").clone(true);
			sentenceDiv.children("#inputSentence").removeAttr("value");
			sentenceDiv.children("#rmBtnNth").children("#nth").remove();
			sentenceDiv.children("#rmBtnNth").append('<button id="nth" class="btn btn-warning" type="button">'
					+ num + '</button>');
			$("#sentences").append(sentenceDiv);

			
			$("select#exception").children().remove();
			$("select#exception").append('<option value="exception">Exception</option>');
			for (var i = 1; i <= num; i++) {
				$("select#exception").append('<option value="' + i +'">' + i + '</option>');
			}
		});

		$("#rmSentenceBtn").click(function() {
			$(this).parent().parent().remove();
			num = num - 1;
			$("select#exception").children().remove();
			$("select#exception").append('<option value="exception">exception</option>');
			for (var i = 1; i <= num; i++) {
				$("select#exception").append('<option value="' + i +'">' + i + '</option>');
				$("span#rmBtnNth").children("#nth").remove();
				
			}
			for (var i = 1; i <= num; i++) {
				$("div#sentence:nth-child(" + i + ")").children("#rmBtnNth").append('<button id="nth" class="btn btn-warning" type="button">'
						+ i + '</button>');
			}
		});
	});
</script>

</body>
</html>
