package com.example.mccomasgymshare;

public class MuscleArrays {
    private int[] abs, back, arms, chest, legs;
    private String[] absText, backText, armsText, chestText, legsText;
    
    public MuscleArrays(){
        abs = new int[]{R.drawable.abs1, R.drawable.abs2, R.drawable.abs3,R.drawable.abs4,
                R.drawable.abs5,R.drawable.abs6,R.drawable.abs7,R.drawable.abs8};
        absText = new String[]{"Bicycle Crunch", "Cable Crunch", "Decline Crunch",
                "Hanging Leg Raises", "Hyperextension", "Plank", "Russian Twists", "V-Ups" };
        arms = new int[]{R.drawable.arms1, R.drawable.arms2, R.drawable.arms3,R.drawable.arms4,
                R.drawable.arms5,R.drawable.arms6,R.drawable.arms7,R.drawable.arms8};
        armsText = new String[]{"Bicep Curl", "Cable Bicep Curl", "Hammer Curl", "Preacher Curl",
                "Skull Crushers", "Tricep Dip", "Tricep Extension", "Tricep Pulldown"};
        back= new int[]{R.drawable.back1, R.drawable.back2, R.drawable.back3,R.drawable.back4,
                R.drawable.back5,R.drawable.back6,R.drawable.back7,R.drawable.back8};
        backText = new String[]{"Bench Row", "Bent Over Row", "Lat Pulldown", "Seated Row",
                "Seated Shoulder Press", "Shoulder Shrug", "Standing Shoulder Press", "Upright Row"};
        chest = new int[]{R.drawable.chest1, R.drawable.chest2, R.drawable.chest3,R.drawable.chest4,
                R.drawable.chest5,R.drawable.chest6,R.drawable.chest7,R.drawable.chest8};
        chestText = new String[]{"Bench Press", "Cable Fly", "Chest Press", "Decline Bar Press",
                "Dumbbell Fly", "Incline Bench Press", "Incline Dumbbell Press", "Low Cable Cross"};
        legs = new int[]{R.drawable.legs1, R.drawable.legs2, R.drawable.legs3,R.drawable.legs4,
                R.drawable.legs5,R.drawable.legs6,R.drawable.legs7,R.drawable.legs8};
        legsText = new String[]{"Deadlift", "Hip Abductor", "Leg Extension", "Leg Press",
                "Seated Calf Raises", "Seated Leg Curl", "Squat", "Standing Calf Raises"};
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
