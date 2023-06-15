package com.example.githubclient
class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun counterClick(id: Int) {
        when(id) {
            INDEX_BUTTON_1 -> {
                val nextValue = model.next(INDEX_BUTTON_1)
                view.setButtonText(INDEX_BUTTON_1, nextValue.toString())
            }
            INDEX_BUTTON_2 -> {
                val nextValue = model.next(INDEX_BUTTON_2)
                view.setButtonText(INDEX_BUTTON_2,nextValue.toString())
            }
            INDEX_BUTTON_3 -> {
                val nextValue = model.next(INDEX_BUTTON_3)
                view.setButtonText(INDEX_BUTTON_3,nextValue.toString())
            }
        }
    }
}