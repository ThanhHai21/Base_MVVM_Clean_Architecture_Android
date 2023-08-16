package com.mybasecode.noteapp.presentation.modules.editnote

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.navArgs
import com.mybasecode.noteapp.presentation.model.NoteModel
import com.mybasecode.noteapp.presentation.modules.addnote.AddNoteFragment
import com.mybasecode.noteapp.presentation.modules.home.HomeFragmentDirections
import com.mybasecode.noteapp.shared.exts.changeBackgroundColor
import com.mybasecode.noteapp.shared.exts.setOnDelayClickListener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EditNoteFragment : AddNoteFragment() {
    private val args by navArgs<EditNoteFragmentArgs>()
    private val noteModel by lazy { args.noteModel }

    companion object {
        fun navigateFromHomeScreen(navController: NavController, noteModel: NoteModel) {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(noteModel))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteModel.colorHex.let {
            getViewModel().selectedColor = it
            getViewBinding().btColorPicker.changeBackgroundColor(it)
        }

        getViewBinding().etTitle.setText(noteModel.title)
        getViewBinding().etContent.setText(noteModel.content)
    }

    override fun registerViewEvent() {
        super.registerViewEvent()
        getViewBinding().btBack.setOnDelayClickListener {
            val (title, content) = getTitleAndContent()
            val isSameTitle = title == noteModel.title
            val isSameContent = content == noteModel.content
            val isSameColor = getViewModel().selectedColor == noteModel.colorHex

            when {
                !isSameTitle || !isSameContent || !isSameColor -> {
                    discardDialog.show()
                }
                else -> {
                    onDiscard()
                }
            }
        }

        getViewBinding().btSave.setOnDelayClickListener {
            val (title, content) = getTitleAndContent()
            if (getViewModel().validateInput(title, content)) {
                saveConfirmDialog.show()
            }
        }
    }

    override fun onSaveNote() {
        val (title, content) = getTitleAndContent()
        getViewModel().updateNote(noteModel.id, title, content)
    }
}