package com.example.ccm2.repository

import com.example.ccm2.model.MyObjectForRecyclerView
import com.example.ccm2.model.ObjectDataFooterSample
import com.example.ccm2.model.ObjectDataHeaderSample
import com.example.ccm2.model.ObjectDataSample

class AndroidVersionRepository {

    fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()
        // Create data raw
        mutableListOf(
            ObjectDataSample("Android Lollipop", 5,"https://motorola-global-portal-pt.custhelp.com/euf/assets/images/ProdImages/motocare/9295-hero.png"),
            ObjectDataSample("Android Marshmallow", 6,"https://images.frandroid.com/wp-content/uploads/2015/08/image00.png"),
            ObjectDataSample("Android Nougat", 7,"https://e7.pngegg.com/pngimages/462/550/png-clipart-android-software-development-google-play-linux-kernel-android-nougat-logo-computer-wallpaper.png"),
            ObjectDataSample("Android Oreo", 8,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Android_Oreo_8.1_logo.svg/1200px-Android_Oreo_8.1_logo.svg.png"),
            ObjectDataSample("Android Pie", 9,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Android_P_logo.svg/1200px-Android_P_logo.svg.png"),
            ObjectDataSample("Android Q", 10,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Android_Q_Logo.svg/600px-Android_Q_Logo.svg.png"),
            ObjectDataSample("Android R", 11,"https://images.emojiterra.com/google/android-11/512px/ae.png"),
            ObjectDataSample("Android S", 12,"https://img1.freepng.fr/20171220/zoe/android-logo-png-5a3ab0bc11e079.0040072615137957720732.jpg")
        ).groupBy {
            // Split in 2 list, modulo and not
            it.versionCode % 2 == 0
        }.forEach { (isModulo, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            result.add(ObjectDataHeaderSample("Is modulo : $isModulo"))
            result.addAll(items)
            result.add(ObjectDataFooterSample("Is footer"))
        }
        return result
    }
}