package com.example.mccomasgymshare;

public class MuscleArrays {
    private int[] abs, back, arms, chest, legs;
    private String[] absText, backText, armsText, chestText, legsText;
    
    public MuscleArrays(){
        abs = new int[]{R.drawable.abs1, R.drawable.abs2, R.drawable.abs3,R.drawable.abs4,
                R.drawable.abs5,R.drawable.abs6,R.drawable.abs7,R.drawable.abs8, R.drawable.abs9,
                R.drawable.abs10, R.drawable.abs11, R.drawable.abs12, R.drawable.abs13,R.drawable.abs14,
                R.drawable.abs15, R.drawable.abs16};
        absText = new String[]{"Bicycle Crunch", "Cable Crunch", "Crunch", "Decline Crunch",
                "Flutter Kicks", "Hanging Leg Raises", "Hyperextension", "Leg Raises", "Mountain Climbers",
                "Plank", "Reverse Crunch", "Russian Twists", "Seated Crunch", "Side Plank",
                "Toe Touches", "V-Ups" };
        arms = new int[]{R.drawable.arms1, R.drawable.arms2, R.drawable.arms3,R.drawable.arms4,
                R.drawable.arms5,R.drawable.arms6,R.drawable.arms7,R.drawable.arms8, R.drawable.arms9,
                R.drawable.arms10, R.drawable.arms11, R.drawable.arms12, R.drawable.arms13, R.drawable.arms14,
                R.drawable.arms15, R.drawable.arms16};
        armsText = new String[]{"Barbell Bicep Curl", "Bent Over Tricep Extension", "Bicep Curl",
                "Cable Bicep Curl", "Hammer Curl", "Overhead Cable Curls", "Overhead Tricep Extension",
                "Preacher Curl", "Preacher Curl Machine", "Skull Crushers", "Standing One Arm Curl",
                "Tricep Dip", "Tricep Extension", "Tricep Pulldown", "Tricep Pushups", "Wrist Curl"};
        back= new int[]{R.drawable.back1, R.drawable.back2, R.drawable.back3,R.drawable.back4,
                R.drawable.back5,R.drawable.back6,R.drawable.back7,R.drawable.back8, R.drawable.back9,
                R.drawable.back10, R.drawable.back11, R.drawable.back12, R.drawable.back13, R.drawable.back14,
                R.drawable.back15, R.drawable.back16, R.drawable.back17, R.drawable.back18};
        backText = new String[]{"Assisted Pullup", "Bench Row", "Bent Over Row", "Face Pulls", "Front Raises",
                "Lat Pulldown","Lat Pulldown Machine", "Lateral Dumbbell Raises", "Pullup",
                "Reverse Fly Machine","Reverse Flys", "Seated Row", "Seated Row Machine", "Seated Shoulder Press",
                "Seated Shoulder Machine", "Shoulder Shrug", "Standing Shoulder Press", "Upright Row"};
        chest = new int[]{R.drawable.chest1, R.drawable.chest2, R.drawable.chest3,R.drawable.chest4,
                R.drawable.chest5,R.drawable.chest6,R.drawable.chest7,R.drawable.chest8,R.drawable.chest9,
                R.drawable.chest10, R.drawable.chest11, R.drawable.chest12, R.drawable.chest13,
                R.drawable.chest14, R.drawable.chest15, R.drawable.chest16};
        chestText = new String[]{"Bench Press", "Cable Fly", "Chest Press", "Decline Bar Press",
                "Decline Pushup", "Dumbbell Bench Press", "Dumbbell Fly", "Dumbbell Pullovers",
                "Hindu Pushup", "Incline Bench Press", "Incline Dumbbell Flys", "Incline Dumbbell Press",
                "Incline Pushups", "Low Cable Cross", "Pushups", "Seated Fly Machine"};
        legs = new int[]{R.drawable.legs1, R.drawable.legs2, R.drawable.legs3,R.drawable.legs4,
                R.drawable.legs5,R.drawable.legs6,R.drawable.legs7,R.drawable.legs8,R.drawable.legs9,
                R.drawable.legs10,R.drawable.legs11, R.drawable.legs12,R.drawable.legs13, R.drawable.legs14,
                R.drawable.legs15, R.drawable.legs16};
        legsText = new String[]{"Barbell Lunges", "Box Jumps", "Bulgarian Split Squats", "Deadlift",
                "Donkey Kicks", "Hip Abductor", "Inner Thigh Machine",  "Leg Extension", "Leg Press",
                "Lying Leg Curls", "Seated Calf Raises", "Seated Leg Curl", "Seated Leg Press",
                "Single Leg Deadlift", "Squat", "Standing Calf Raises"};
    }

    public int[] getAbs() {
        return abs;
    }

    public int[] getBack() {
        return back;
    }

    public int[] getArms() {
        return arms;
    }

    public int[] getChest() {
        return chest;
    }

    public int[] getLegs() {
        return legs;
    }

    public String[] getAbsText() {
        return absText;
    }

    public String[] getBackText() {
        return backText;
    }

    public String[] getArmsText() {
        return armsText;
    }

    public String[] getChestText() {
        return chestText;
    }

    public String[] getLegsText() {
        return legsText;
    }
}
