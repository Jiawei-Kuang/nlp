<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>Sentence Parser</title>

    <link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/css/bootstrap-select.min.css"    rel="stylesheet">
    <link href="<c:url value="/resources/css/parserView.css" />" rel="stylesheet" type="text/css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/js/bootstrap-select.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/parserView.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>

    <ul class="nav nav-tabs" role="tablist">
        <li class="active"><a href="home">Home</a></li>
        <li><a href="parser">Parser</a></li>
    </ul>

    <div align='center'>
        <h2>Sentence Parser<br><br></h2>
    </div>
    
    <c:if test="${model.isValidSentence == false}">
        <div align='center'>
            <p id="invalidSentence" style="color:red">${model.exceptionMessage}<br></p>
        </div>
    </c:if>

    <form id="form">
    	<div id="paragraph" align='center'>
    		<textarea class="inputTextArea" rows="5" cols="100" name="${model.inputParagraph}"></textarea>
    		<br><br>
    		<button id="btnParse" class="btn btn-primary btn-pad" type="submit" name="submit" value="sentences">Sentences</button>
    	</div>
    	<br>
    	<!-- 
        <div id="sentences">
            <div id="sentence" class="input-group">

                <span class="input-group-btn">
                    <button id="rmSentenceBtn" class="btn btn-danger" type="button">
                        <span class="glyphicon glyphicon-minus"></span>
                    </button>
                </span>
                

                <span id="sentenceSequenceNumber" class="input-group-btn">
                    <button id="sequenceNumber" class="btn btn-default" type="button">1
                    </button>
                </span>
                

                <select id="questionType" class="selectpicker" name="${model.questionType}" data-width="85px">
                    <c:forEach var="qType" items="${model.questionTypes}">
                        <option value="${qType}">${qType}</option>
                    </c:forEach>
                </select>
                

                <input type="text" id="inputSentence" name="${model.inputSentence}" 
                    class="form-control" placeholder="input sentence">
                <span id="if" class="input-group-addon">${model.If}</span>
                <input type="text" id="ifSentence" name="${model.ifSentence}"
                    class="form-control" placeholder="if condition">
                <span id="then" class="input-group-addon">${model.Then}</span>
                <input type="text" id="thenSentence" name="${model.thenSentence}"
                    class="form-control" placeholder="then sentence">
                <span id="questionMark" class="input-group-addon">?</span>
                

                <span class="input-group-btn">
                    <select id="sentenceType" name="${model.sentenceType}" class="btn btn-default">
                        <c:forEach var="type" items="${model.sentenceTypes}">
                            <option value="${type}">${type}</option>
                        </c:forEach>
                    </select>
                </span>


                <select id="sentenceParameter" class="selectpicker" name="${model.sentenceParameter}" data-width="110px">
                    <c:forEach var="parameter" items="${model.sentenceParameters}">
                        <option value="${parameter}">${parameter}</option>
                    </c:forEach>
                </select>


                <span id="dummyException" class="input-group-addon"> 
                    <select name="exception" class="btn btn-default">
                        <option value="0"></option>
                    </select>
                </span>


                <select id="exception" class="selectpicker" multiple title='Except With' name="${model.exception}" data-width="120px">
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
         -->

        <c:if test="${model.isValidSentence == true}">
    	<!-- Table for input sentences, drs and fol -->
    	<c:if test="${not empty model.sentences}">
    		<div class="table-responsive">
      			<table class="table table-bordered">
      				<col width="3%">
      				<col width="7%">
      				<col width="7%">
      				<col width="33%">
  					<col width="25%">
  					<col width="25%">
        			<thead>
         				<tr>
            			 	<th class="bg-success">#</th>
            			 	<th class="bg-success">Parameter</th>
            			 	<th class="bg-success">Exception</th>
           				 	<th class="bg-success">Sentence</th>
            				<th class="bg-success">DRS</th>
            				<th class="bg-success">FOL</th>
          				</tr>
        			</thead>
        			<tbody>
          				<c:forEach var="sentence" items="${model.sentences}">
          				<tr>
          					<td>${sentence.num}
          					</td>
          					<td>
								<!-- sentence parameter e.g. Strict and Defeasible -->
                				<select id="sentenceParameter" class="selectpicker" name="${model.sentenceParameter}" data-width="110px">
                    				<c:forEach var="parameter" items="${model.sentenceParameters}">
                        				<option value="${parameter}">${parameter}</option>
                    				</c:forEach>
                				</select>
          					</td>
          					<td>
                				<!-- This dummyException is used to separate each sentences' exceptions -->
                				<span id="dummyException" class="input-group-addon"> 
                    				<select name="exception" class="btn btn-default">
                       					<option value="0"></option>
                    				</select>
                				</span>

                				<!-- Multiple select for exceptions 
                				<select id="exception" class="selectpicker" multiple title='Exception' name="${model.exception}" data-width="120px">
                    				<option value="1">1</option>
                				</select>
                				-->
                				<select id="exception" class="selectpicker" multiple title='Exception' name="${model.exception}" data-width="120px">
                					<c:forEach var="optionValue" items="${model.exceptionOptions}">
                    					<option value="${optionValue}">${optionValue}</option>
                					</c:forEach>
                				</select>
          					</td>
          					<td>			
                    			<input type="text" id="inputSentence" name="inputSentence"
                        			class="form-control" value="${sentence.sentence}">
          					</td>
          					
          					<td <c:if test="${sentence.drsParseSuccess == false or empty sentence.sentence}">style="color:red"</c:if>>${sentence.drs}</td>
          					<td <c:if test="${sentence.folParseSuccess == false or empty sentence.sentence}">style="color:red"</c:if>>${sentence.fol}</td>
          					</tr>
          				</c:forEach>
        			</tbody>
      			</table>
    		</div>

    		<div align='center'>
            <button id="parseBtn" class="btn btn-primary btn-pad" type="submit"
                name="submit" value="update">Update</button>
        	</div>
		</c:if>
		</c:if>
    </form>
    <br>
    <br>
    <c:if test="${model.isValidSentence == true}">
        <!-- Display the input sentences
        <c:if test="${not empty model.sentences}">
            <c:forEach var="sentence" items="${model.sentences}">
                <div id="inputSentence" class="input-group">
                    <span class="input-group-btn">
                    <button id="nth" class="btn btn-warning" type="button">${sentence.num}</button>
                    </span>
                    <input type="text" id="inputSentence" name="inputSentence"
                        class="form-control" value="${sentence.sentence}" readonly="readonly">
                    <c:if test="${not empty sentence.exceptions}">
                        <span class="input-group-btn">
                            <button class="btn btn-info">Exception With</button>
                            <c:forEach var="exception" items="${sentence.exceptions}">
                                    <button id="nth" class="btn btn-warning" type="button">${exception}</button>
                            </c:forEach>
                        </span>
                    </c:if>
                </div>
            </c:forEach>
        </c:if>
        <br>
         -->
        <!-- Sentence DRS result
        <c:if test="${not empty model.sentences}">
            <div id=drs class="input-group">
                <span class="input-group-btn">
                    <button class="btn btn-success">DRS</button>
                </span> 
                <input type="text" id="drs" name="drs" class="form-control"
                        value="${model.sentences[0].drs}" readonly="readonly">
            </div>
        </c:if>
        <br>
         -->
        <!-- Sentence FOL result
        <c:if test="${not empty model.sentences}">
            <div id=fol class="input-group">
                <span class="input-group-btn">
                    <button class="btn btn-success">FOL</button>
                </span> 
                <input type="text" id="fol" name="fol" class="form-control"
                        value="${model.sentences[0].fol}" readonly="readonly">
            </div>
        </c:if>
         -->
    </c:if>
</body>
</html>
