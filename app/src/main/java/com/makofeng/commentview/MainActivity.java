package com.makofeng.commentview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private CommentView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv = (CommentView) findViewById(R.id.cv);

        List<CommentModel> commentModels = new ArrayList<CommentModel>();

        for (int i = 0; i < 10; i++) {

            CommentModel commentModel = new CommentModel();
            commentModel.setContent("aaaaaaa");
            commentModel.setUserId("2" + i);
            commentModel.setUserName("fenghao");
            commentModels.add(commentModel);
        }

        cv.initCommentLayout(commentModels);

        cv.setonCommentItemClickListener(new CommentView.OnUserItemClickListener() {
            @Override
            public void onTextClick(CommentModel commentModel) {
                Toast.makeText(MainActivity.this, commentModel.getUserId(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
