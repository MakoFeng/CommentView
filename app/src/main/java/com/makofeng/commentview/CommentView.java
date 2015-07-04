package com.makofeng.commentview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fenghao on 2015/7/3.
 */
public class CommentView extends LinearLayout {


    private Context mContext;

    public CommentView(Context context) {
        this(context, null);
    }

    public CommentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CommentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        setOrientation(LinearLayout.VERTICAL);
    }


    public void initCommentLayout(List<CommentModel> commentModels) {


        if (commentModels == null || commentModels.size() == 0)
            return;

        for (int i = 0; i < commentModels.size(); i++) {
            final CommentModel model = commentModels.get(i);
            View ll = LayoutInflater.from(mContext).inflate(R.layout.comment_text, null);
            TextView tv_comment = (TextView) ll.findViewById(R.id.tv);
            tv_comment.setMovementMethod(LinkMovementMethod.getInstance());
            String content = model.getContent() == null ? "" : model.getContent();
            String nickName = model.getUserName();
            String userId = model.getUserId();
            SpannableString ss = new SpannableString(nickName + "：" + content);


            UserClickSpan userClickSpan = new UserClickSpan(false) {
                @Override
                public void onClick(View view) {
                    onTextClick.onTextClick(model);
                }
            };

            ss.setSpan(userClickSpan, 0, nickName.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


            tv_comment.setText(ss);
            addView(ll);
        }


        invalidate();

    }

    OnUserItemClickListener onTextClick;

    public void setonCommentItemClickListener(OnUserItemClickListener onTextClick) {
        this.onTextClick = onTextClick;
    }


    public interface OnUserItemClickListener {

        void onTextClick(CommentModel commentModel);
    }


}
