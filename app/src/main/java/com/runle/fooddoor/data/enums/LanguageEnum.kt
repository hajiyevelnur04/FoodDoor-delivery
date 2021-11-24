package com.runle.fooddoor.data.enums

enum class LanguageEnum {
    AZ, RU, ENG, TR;

    override fun toString(): String {
        return name.lowercase()
    }

}
