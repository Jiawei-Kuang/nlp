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

    <form id="form">
        <div id="paragraph" align='center'>
            <textarea class="inputTextArea" rows="5" cols="100" name="${model.inputParagraph}"></textarea>
            <br><br>
            <button id="btnParse" class="btn btn-primary btn-pad" type="submit" name="submit" value="sentences">Sentences</button>
        </div>
        <br>

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
                              <td>${sentence.num}</td>
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
                                <select id="exception" class="selectpicker" multiple title='Exception' name="${model.exception}" data-width="120px">
                                    <c:forEach var="optionValue" items="${model.exceptionOptions}">
                                        <option value="${optionValue}">${optionValue}</option>
                                    </c:forEach>
                                </select>
                              </td>
                              <td>            
                                <input type="text" id="inputSentence" name="inputSentence" class="form-control" value="${sentence.sentence}">
                              </td>
                              <td <c:if test="${sentence.drsParseSuccess == false or empty sentence.sentence}">style="color:red"</c:if>>${sentence.drs}</td>
                              <td <c:if test="${sentence.folParseSuccess == false or empty sentence.sentence}">style="color:red"</c:if>>${sentence.fol}</td>
                              </tr>
                          </c:forEach>
                    </tbody>
                  </table>
            </div>

            <div align='center'>
                <button id="parseBtn" class="btn btn-primary btn-pad" type="submit" name="submit" value="update">Update</button>
            </div>
        </c:if>
    </form>
</body>
</html>
