package com.hb.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import com.hb.R;
import com.hb.model.Holiday;
import com.hb.service.HolidayService;
import com.hb.view.DeckCardImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HBActivity extends Activity implements GestureDetector.OnGestureListener {

    public static final String TAG = "HBActivity";

    public static final int FIRST_CARD = 0;
    public static final String FILE_EXTENSION = ".png";
    public static final String IMAGES_FOLDER = "images/";

    private GestureDetectorCompat gestureDetectorCompat;

    private DeckCardImageView deckCardImageView;
    private TextView currentPage;
    private TextView totalPages;
    private TextView weather;
    private TextView daysToGo;

    private Holiday holiday;
    private List<String> cards;
    private int currentCardPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        holiday = new HolidayService().getHolidayDetails(this);
        cards = holiday.getCards();

        deckCardImageView = (DeckCardImageView) findViewById(R.id.deck_card_images);
        currentPage = (TextView) findViewById(R.id.current_page);
        totalPages = (TextView) findViewById(R.id.total_page);
        weather = (TextView) findViewById(R.id.city_weather);
        daysToGo = (TextView) findViewById(R.id.days_to_go);

        if (cards.size() > 0) {
            setImage(cards.get(FIRST_CARD));
            currentPage.setText(String.valueOf((currentCardPosition + 1)));
            totalPages.setText(String.valueOf(cards.size()));

        }
        weather.setText(String.valueOf(holiday.getWeather()));
        daysToGo.setText(String.valueOf(holiday.getDaysToGo()));

        gestureDetectorCompat = new GestureDetectorCompat(this, this);
        deckCardImageView.setGestureDetectorCompat(gestureDetectorCompat);

        currentCardPosition = 0;
    }

    private void setImage(String imageName) {
        try {
            InputStream ims = getAssets().open(IMAGES_FOLDER + imageName + FILE_EXTENSION);
            Drawable d = Drawable.createFromStream(ims, null);
            deckCardImageView.setImageDrawable(d);
        } catch (IOException ex) {
            Log.e(TAG, "Exception while loading image");
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        currentCardPosition++;
        if (currentCardPosition < cards.size()) {
            setImage(cards.get(currentCardPosition));
            currentPage.setText(String.valueOf((currentCardPosition + 1)));
        }
        return false;
    }


}
