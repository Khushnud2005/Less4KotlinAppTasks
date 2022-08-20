package uz.exemple.less4kotlinapp.model

import java.io.Serializable

class Member(val id:Int,val name:String):Serializable {
    override fun toString():String{
        return "Member{" +
                "name=" + name +
                ", id=" + id +
                '}'
    }
}