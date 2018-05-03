package Model.postData

import Model.Magic.CircleTransform
import Model.postData.Comment.comment
import Model.postData.Comment.commentViewHolder
import android.app.Dialog
import android.support.design.widget.Snackbar;
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.helpme.Comment.ShowComments
import com.helpme.R
import org.w3c.dom.Text

class postAdapter(var mContext: Context, var postList: ArrayList<post>, var postType: Int) : RecyclerView.Adapter<postViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.post_card, parent, false)
        return postViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        var postToBind: post = postList[position];
        holder?.postContent?.text = postToBind.postContent;
        holder?.postType?.setImageResource(postType);
        holder?.postOwnerUserName?.text = postToBind.postOwnerUserName
        holder?.showCommentsButton?.setOnClickListener {
            //val dialog: Dialog = Dialog(mContext)
            //dialog.setContentView(R.layout.activity_show_comments);
            //dialog.show()
            val intent: Intent = Intent(mContext, ShowComments::class.java)
            mContext.startActivity(intent)
        }
        holder?.itemView?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Snackbar.make(holder.view, postToBind.postContent, Snackbar.LENGTH_SHORT).show()
            }
        })
        holder?.postImage?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Snackbar.make(holder.view, postToBind.postContent, Snackbar.LENGTH_SHORT).show()
            }
        })
        applyProfilePicture(holder!!, postToBind)
        // dh by3mel load ll post cover using Glide library gamed f45
        Glide.with(mContext).load(postToBind.postImage).into(holder?.postImage);    }

    override fun getItemCount(): Int {
        return postList.size;
    }
    private fun applyProfilePicture(holder: postViewHolder, Post: post) {
        if (!TextUtils.isEmpty(Post.postOwnerImage)) {
            Glide.with(mContext).load(Post.postOwnerImage)
                    .thumbnail(0.5f)
                    .crossFade()
                    .transform(CircleTransform(mContext))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.postOwnerImage!!)
            holder.postOwnerImage!!.colorFilter = null
        } else {
            holder.postOwnerImage!!.setImageResource(R.drawable.bg_circle)
            holder.postOwnerImage!!.setColorFilter(Post.color)
        }
    }
}