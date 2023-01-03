package com.exxuslee.ui.main

import com.exxuslee.core.Communication
import com.exxuslee.core.SingleLiveEvent
import com.exxuslee.domain.model.Player

interface MainCommunication {

    interface Put : Communication.Put<List<Player>>
    interface Post : Communication.Post<List<Player>>
    interface Observe : Communication.Observe<List<Player>>

    interface Mutable : Put, Observe, Post

    class Base : Communication.Abstract<List<Player>>(SingleLiveEvent()), Mutable
}