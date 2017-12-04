package pl.khuzzuk.survey.surveys;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QuestionModel {
    private String name;
    private String type;
    private String title;
    private String inputMask;
    private String inputType;
    private int colCount;
    private List<String> choices;
    private List<Validator> validators;
    private boolean isRequired;

    public QuestionModel() {
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public int getColCount() {
        return this.colCount;
    }

    public List<String> getChoices() {
        return this.choices;
    }

    @JsonProperty("isRequired")
    public boolean isRequired() {
        return this.isRequired;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getInputMask() {
        return inputMask;
    }

    public void setInputMask(String inputMask) {
        this.inputMask = inputMask;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public List<Validator> getValidators() {
        return validators;
    }

    public void setValidators(List<Validator> validators) {
        this.validators = validators;
    }
}
