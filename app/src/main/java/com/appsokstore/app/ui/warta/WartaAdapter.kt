package com.appsokstore.app.ui.warta

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.appsokstore.app.R
import com.appsokstore.app.data.model.Warta
import com.appsokstore.app.databinding.ItemWartaBinding
import com.appsokstore.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class WartaAdapter(val context: Context) : BaseAdapter<Warta>(R.layout.item_warta) {
    override fun onBind(binding: ViewDataBinding?, data: Warta) {
        val mBinding = binding as ItemWartaBinding
        Glide.with(context).load(data.poster).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: Warta) {
        val intent = Intent(context, WartaActivity::class.java)
        intent.putExtra(WartaActivity.OPEN_WARTA, data)
        context.startActivity(intent)
    }
}