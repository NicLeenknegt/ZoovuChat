package com.zoovu.zuuvochat.fragments.conversation_list


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zoovu.zuuvochat.MainActivity

import com.zoovu.zuuvochat.R
import com.zoovu.zuuvochat.domain.Model
import com.zoovu.zuuvochat.domain.viewmodels.ConversationViewModel
import kotlinx.android.synthetic.main.fragment_conversation_list.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 *
 */
class ConversationListFragment : Fragment() {

    private lateinit var conViewModel:ConversationViewModel
    private lateinit var conversationListAdapter: ConversationListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conversation_list, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.run {
            conViewModel = ViewModelProviders.of(this).get(ConversationViewModel::class.java)
        }?: throw Exception("Invalid activity.")
        conversationListAdapter = ConversationListAdapter(this, conViewModel, activity as MainActivity)
        conViewModel.conversations.value!!.add(Model.Conversation("cjwix19y2007clrqrtyagcfjz", "TestBot 1", arrayListOf()))
        conViewModel.conversations.value!!.add(Model.Conversation("cjwix19y2007clrqrtyagcfjz", "TestBot 2", arrayListOf()))
        conViewModel.conversations.value!!.add(Model.Conversation("cjwix19y2007clrqrtyagcfjz", "TestBot 3", arrayListOf()))
        conViewModel.conversations.value!!.add(Model.Conversation("cjwix19y2007clrqrtyagcfjz", "TestBot 4", arrayListOf()))
        conViewModel.conversations.value!!.add(Model.Conversation("cjwix19y2007clrqrtyagcfjz", "TestBot 5", arrayListOf()))
        conViewModel.conversations.value!!.add(Model.Conversation("cjwix19y2007clrqrtyagcfjz", "TestBot 6", arrayListOf()))
        conViewModel.conversations.value!!.add(Model.Conversation("cjwix19y2007clrqrtyagcfjz", "TestBot 7", arrayListOf()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        conversation_grid_view.apply {
            adapter = conversationListAdapter
        }
    }
}