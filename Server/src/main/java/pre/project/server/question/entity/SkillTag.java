package pre.project.server.question.entity;

public enum SkillTag {
    TAG_JAVA("JAVA"),
    TAG_JAVASCRIPT("JAVASCRIPT"),
    TAG_PHP("PHP"),
    TAG_REACT("REACT"),
    TAG_HTML("HTML"),
    TAG_CSS("CSS"),
    TAG_IOS("IOS"),
    TAG_ANDROID("ANDROID"),
    TAG_API("API"),
    TAG_PYTHON("PYTHON");

    private String tag;

    SkillTag(String tag) {
        this.tag = tag;
    }
}