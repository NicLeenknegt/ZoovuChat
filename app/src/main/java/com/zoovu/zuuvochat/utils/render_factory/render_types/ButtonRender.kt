package com.zoovu.zuuvochat.utils.render_factory.render_types

import com.zoovu.zuuvochat.domain.Model
import com.zoovu.zuuvochat.utils.render_factory.render_builder.MessageBuilder
import org.json.JSONObject

class ButtonRender:RenderType {

    private var messages:ArrayList<Model.Message> = arrayListOf()

    override fun renderMessage(json: JSONObject): MessageBuilder {
        messages.add(
            Model.Message(
                "none",
                json.getString("buttonQuestion").toString(),
                json.getBoolean("isHorizontal")
            )
        )

        var jsonArray = json.getJSONArray("text")
        for (i in 0 until jsonArray.length()) {
            messages.add(
                Model.Message(
                    "none",
                    jsonArray.getJSONObject(i).getString("text").toString(),
                    json.getBoolean("isHorizontal")
                )
            )
        }
        return MessageBuilder(messages)
    }


}