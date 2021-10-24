package com.example.a7minuteworkout

class Constacts {

    // basically use of companion object to declare multiple variable
    companion object{

        fun defualtExcersiceList():ArrayList<ExersiceModel>{

            var exersiceList=ArrayList<ExersiceModel> ()

            val jumpingJacks=ExersiceModel(1,
                "JumpingJacks",
                R.drawable.ic_jumping_jacks,
                false,
                false)

            exersiceList.add(jumpingJacks)

            val wallSit=ExersiceModel(2,
                "Wall Sit",
                R.drawable.ic_wall_sit,
                false,
                false)

            exersiceList.add(wallSit)

            val pushUp=ExersiceModel(3,
                "Push Up",
                R.drawable.ic_push_up,
                false,
                false)

            exersiceList.add(pushUp)

            val abdominalCrunch=ExersiceModel(4,
                "Abdominal Crunch",
                R.drawable.ic_abdominal_crunch,
                false,
                false)

            exersiceList.add(abdominalCrunch)

            val setUpOnChain=ExersiceModel(5,
                "Step-up onto Chair",
                R.drawable.ic_step_up_onto_chair,
                false,
                false)

            exersiceList.add(setUpOnChain)

            val squat=ExersiceModel(6,
                "Squat",
                R.drawable.ic_squat,
                false,
                false)

            exersiceList.add(squat)

            val tricepDipOnChair=ExersiceModel(7,
                "Tricep Dip On Chair",
                R.drawable.ic_triceps_dip_on_chair,
                false,
                false)

            exersiceList.add(tricepDipOnChair)

            val highKneesRunningInPlace=ExersiceModel(8,
                "High Knees Running In Place",
                R.drawable.ic_high_knees_running_in_place,
                false,
                false)

            exersiceList.add(highKneesRunningInPlace)

            val lunges=ExersiceModel(9,
                "Lunges",
                R.drawable.ic_lunge,
                false,
                false)

            exersiceList.add(lunges)

            val pushUpAndRotation=ExersiceModel(10,
                "Push Up and Rotation",
                R.drawable.ic_jumping_jacks,
                false,
                false)

            exersiceList.add(pushUpAndRotation)


            val sidePlack=ExersiceModel(11,
                "Side Plank",
                R.drawable.ic_side_plank,
                false,
                false)

            exersiceList.add(sidePlack)

            return exersiceList
        }

    }

}