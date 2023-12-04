package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.enums;

public enum SkillLevel {
    BEGINNER(0), ADVANCED(1), PROFESSIONAL(2), INTERMEDIATE(3), MASTER(4);
    private final int code;
    SkillLevel(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public static SkillLevel getValue(int code) {
        switch(code) {
            case 0 -> { return BEGINNER; }
            case 1 -> { return ADVANCED; }
            case 2 -> { return PROFESSIONAL; }
            case 3 -> { return INTERMEDIATE; }
            case 4 -> { return MASTER; }
            default -> throw new NullPointerException("Can't convert the value to a skill level");
        }
    }
}
