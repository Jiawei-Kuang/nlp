/**
 * 
 */

var num = 1;

$(document).ready(function() {
    /**
    * The reason of putting this function at here is 
    * that we need to hide some elements which are
    * dynamically created by selectpicker. (e.g. 
    * div#bootstrap-select)
    */
    enableBootstrapSelect();        
    // Hide the selects and spans which do not need to exposed to user
    hideAllRuleInformations();
    hideAllQuestionInformations();
    hideDummyExceptionSelect();
        
    // Hide or show information when user select sentence type
    $('#sentences').on('change', 'select#sentenceType', function(){
        var sentenceDiv = $(this).parent().parent();
        if ($(this).val().localeCompare("Sentence") == 0) {
            showSentenceInformation(sentenceDiv);
            hideRuleInformation(sentenceDiv);
            hideQuestionInformation(sentenceDiv);
        } else if ($(this).val().localeCompare("Rule") == 0) {
            hideSentenceInformation(sentenceDiv);
            showRuleInformation(sentenceDiv);
            hideQuestionInformation(sentenceDiv);
        } else if ($(this).val().localeCompare("Question") == 0) {
            showSentenceInformation(sentenceDiv);
            hideRuleInformation(sentenceDiv);
            showQuestionInformation(sentenceDiv);
        }
    });
            
    $('#form').on('click', '#addSentenceBtn', function() {
        num = num + 1;
        
        var sentenceDiv = $("#sentence:first").clone();
        sentenceDiv.children("#inputSentence").removeAttr("value");
        addSequenceNumberForNewSentence(sentenceDiv, num);
        $("#sentences").append(sentenceDiv);
        
        // Since later after this statement, we will use function 
        // enableBootstrapSelect() which will create elements for
        // bootstrap select again which is unnecessary
        removeBootstrapCreatedElement(sentenceDiv);
        updateMultiSelect(num);
        // The reason of putting this function here is that we need
        // to use it to take effect on newly created select
        enableBootstrapSelect();
        // After enableBootstrapSelect() above is called, we need to hide
        // all the elements in input area except inputSentence
        showSentenceInformation(sentenceDiv);
        hideRuleInformation(sentenceDiv);
        hideQuestionInformation(sentenceDiv);
    });
    
    $('#form').on('click', '#rmSentenceBtn', function() {
        if (num == 1) {
            return;
        }
        num = num - 1;
        
        // Sentence div is the grand parent element of #rmSentenceBtn
        $(this).parent().parent().remove();
        updateSentenceSequenceNumber(num);
        updateMultiSelect(num);
        // The reason of putting this function here is that we need
        // to use it to take effect on newly created select
        enableBootstrapSelect();
    });        
});

function enableBootstrapSelect() {
    $('.selectpicker').selectpicker({
          style: 'btn-defalut',
          size: 4
    });
}



