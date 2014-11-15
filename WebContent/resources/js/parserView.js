/**
 * 
 */

function hideAllRuleInformations() {
    $("input#ifSentence").hide();
    $("input#thenSentence").hide();
    $("span#if").hide();
    $("span#then").hide();
}
function hideRuleInformation(sentenceDiv) {
    sentenceDiv.children("#ifSentence").hide();
    sentenceDiv.children("#thenSentence").hide();
    sentenceDiv.children("#if").hide();
    sentenceDiv.children("#then").hide();
}

function showRuleInformation(sentenceDiv) {
    sentenceDiv.children("#ifSentence").show();
    sentenceDiv.children("#thenSentence").show();
    sentenceDiv.children("#if").show();
    sentenceDiv.children("#then").show();
}
function hideAllQuestionInformations() {
    /**
     * The reason why not hide select#questionType is that selectpicker hide
     * select#questionType and create button[data-id='questionType']
     */
    $("button[data-id='questionType']").parent().hide();
    $("span#questionMark").hide();
}
function hideQuestionInformation(sentenceDiv) {
    sentenceDiv.children("#questionMark").hide();
    sentenceDiv.children("div.bootstrap-select").children(
            "button[data-id='questionType']").parent().hide();
}
function showQuestionInformation(sentenceDiv) {
    sentenceDiv.children("#questionMark").show();
    sentenceDiv.children("div.bootstrap-select").children(
            "button[data-id='questionType']").parent().show();
}
function hideSentenceInformation(sentenceDiv) {
    sentenceDiv.children("#inputSentence").hide();
}
function showSentenceInformation(sentenceDiv) {
    sentenceDiv.children("#inputSentence").show();
}

function hideDummyExceptionSelect() {
    $("span#dummyException").hide();
}

function getMultiSelect(num) {
    var exception = '<select id="exception" class="selectpicker" multiple'+
        ' title="Except With" name="exception" data-width="120px">';
    for (var i = 1; i <= num; i++) {
        exception += '<option value="' + i +'">' + i + '</option>';
    }
    exception += '</select>';
    return exception;
}

function updateMultiSelect(num) {
    $("select#exception").remove();
    $(".show-tick").remove();
    $("div#sentence").append(getMultiSelect(num));
}

function updateSentenceSequenceNumber(num) {
    $("span#sentenceSequenceNumber").children("#sequenceNumber").remove();
    for (var i = 1; i <= num; i++) {
        $("div#sentence:nth-child(" + i + ")").children(
            "#sentenceSequenceNumber").append('<button id="sequenceNumber"' +
                ' class="btn btn-default" type="button">' +    i + '</button>');
    }
}

function addSequenceNumberForNewSentence(sentenceDiv, num) {
    var sentenceSequenceNumber = sentenceDiv.children("#sentenceSequenceNumber");
    sentenceSequenceNumber.children("#sequenceNumber").remove();
    sentenceSequenceNumber.append('<button id="sequenceNumber" class="btn ' +
            'btn-default" type="button">' + num + '</button>');
}

function removeBootstrapCreatedElement(sentenceDiv) {
    sentenceDiv.children("div.bootstrap-select").children("button[data-id='sentenceParameter']").parent().remove();
    sentenceDiv.children("div.bootstrap-select").children("button[data-id='questionType']").parent().remove();
}