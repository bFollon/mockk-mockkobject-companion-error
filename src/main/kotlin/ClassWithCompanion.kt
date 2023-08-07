class ClassWithCompanion {
    companion object {
        val staticValue = BasicClass("real")
    }

    fun printClassHashAndParameter()  {
        println("Hash code and parameter from class")
        println("Companion hash code: ${ClassWithCompanion.hashCode()}")
        println("Static value hash code: ${staticValue.hashCode()}")
        println("Parameter: ${staticValue.parameter}")
    }

    fun getCompanionHash() = staticValue.hashCode()

}