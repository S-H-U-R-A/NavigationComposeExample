package com.sergio.rodriguez.navigation

import androidx.annotation.StringRes

//RUTAS PARA LA NAVEGACIÓN CON BARRA DE NAVEGACIÓN INFERIOR
sealed class Screen(val route: String, @StringRes val resourceId: Int){
    data object Profile: Screen("profile", resourceId= R.string.profile)
    data object FriendList: Screen(route = "friendlist", resourceId = R.string.friend_list){
        data object FriendDetail: Screen(route = "friendDetail", resourceId = R.string.friend_detail)
    }
    data object About: Screen(route = "about", resourceId = R.string.about)

}