package com.example.a7minuteworkout

public class ExersiceModel(
    private var id: Int,
    private var name: String,
    private var image: Int,
    private var isCompleted: Boolean,
    private var isSelected: Boolean
) {

    fun getId():Int{
        return id
    }

    fun setId(id: Int){
        this.id=id
    }

    fun getName():String{
        return name
    }

    fun setName(name: String){
        this.name=name
    }

    fun setImage(image: Int){
        this.image=image
    }

    fun getImage(): Int {
        return this.image
    }

    fun setCompleted(isCompleted:Boolean){
        this.isCompleted=isCompleted
    }

    fun getCompleted(): Boolean {
        return this.isCompleted
    }

    fun setSelected(isSelected:Boolean){
        this.isSelected=isSelected
    }

    fun getSelected(): Boolean {
        return this.isSelected
    }

}