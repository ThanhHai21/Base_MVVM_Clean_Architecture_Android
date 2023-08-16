package com.mybasecode.noteapp.shared.widget

import android.content.Context
import androidx.annotation.ColorRes
import com.mybasecode.noteapp.databinding.DialogCommonBinding
import com.mybasecode.noteapp.presentation.base.BaseDialog
import com.mybasecode.noteapp.shared.exts.changeBackgroundColor
import com.mybasecode.noteapp.shared.exts.gone
import com.mybasecode.noteapp.shared.exts.setOnDelayClickListener

class CommonDialog(
    context: Context,
    private val title: String,
    private val negativeText: String? = null,
    @ColorRes private val negativeBackgroundColor: Int? = null,
    private val negativeEvent: (() -> Unit)? = null,
    private val positiveText: String? = null,
    @ColorRes private val positiveBackgroundColor: Int? = null,
    private val positiveEvent: (() -> Unit)? = null,
) : BaseDialog<DialogCommonBinding>(context) {
    override fun getLayoutBinding(): DialogCommonBinding {
        return DialogCommonBinding.inflate(layoutInflater)
    }

    override fun initialize() {
        getViewBinding().tvMessage.text = title

        negativeText?.let {
            getViewBinding().btNegative.apply {
                text = it
                negativeBackgroundColor?.let {
                    changeBackgroundColor(it)
                }
                setOnDelayClickListener {
                    dismiss()
                    negativeEvent?.invoke()
                }
            }
        } ?: kotlin.run {
            getViewBinding().btNegative.gone()
        }

        positiveText?.let {
            getViewBinding().btPositive.apply {
                text = it
                positiveBackgroundColor?.let {
                    changeBackgroundColor(it)
                }
                setOnDelayClickListener {
                    dismiss()
                    positiveEvent?.invoke()
                }
            }
        } ?: kotlin.run {
            getViewBinding().btPositive.gone()
        }
    }
}