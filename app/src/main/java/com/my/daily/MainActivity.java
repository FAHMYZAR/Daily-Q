package com.my.daily;

import static com.my.daily.LoginActivity.USERKEY;
import static com.my.daily.LoginActivity.prefs;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.cazaea.sweetalert.SweetAlertDialog;
import com.my.daily.Component.Utils;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native");
    }
    public static boolean editing;
    public static int emm;
    private TextToSpeech textToSpeech;
    Drawable makanannya,minumannya,aktifitasnya,moodnya;
    LinearLayout classmauapa,classmakan,classsnack,classbuah,classminum,classactivity,classmood;
    CardView cardmakan,cardminum,cardsnack,cardbuah,cardactiv,cardmood,nexteoke;
    CardView cardnaskun,cardnasgor,cardsayur,cardayamgor,cardikangor,cardayambak,cardikanbak,cardnugget,cardsosiss;
    CardView cardroti,cardpuding,cardwafer,cardkeripik,cardkentang,cardchiki;
    CardView cardalpukat,cardanggur,cardapel,cardblimbing,cardbluebery,carddurian,
            cardjambu,cardjeruk,cardklengkeng,cardmangga,cardmanggis,cardmelon,cardpisang,cardrambutan;
    CardView cardsusu,cardairmineral,cardteh,cardjusjambu,cardjusjeruk,cardjusalpukat,cardjusapel;
    CardView cardbelajar,cardbermain,cardberibadah,cardtidur,cardmandi,cardpipis,cardberak;
    CardView cardsenang,cardsedih,cardmarah;
    LinearLayout selected,resetmakan,ambilmakan,resetsnack,ambilsnack,resetbuah,ambilbuah,
            resetminum,ambilminum,resetaktifitas,ambilaktifitas,resetmood,ambilmood;
    TextView select,select2;
    ImageView imageonmain,imagedit;
    public static String selectnew,resultseletcnew,ha,sambutan;
    public static native String Telegram();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.navbarwindows(this, R.color.colorAccent);
        final TextView Userku = findViewById(R.id.user);
        Userku.setText(USERKEY);
        UIXBaruLogin();
        UIXImplement();
        makanapa();
        makansnack();
        makanbuah();
        minumapa();
        aktifitasapa();
        sedangmood();
        sambutan = "Hallo Temanku"+USERKEY+"Yang hebat, Semoga harimu selalu menyenangkan!!";
        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {int result = textToSpeech.setLanguage(Locale.getDefault());
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                } else { textToSpeech.speak(sambutan, TextToSpeech.QUEUE_FLUSH, null, "ID");}} else {}
        });
    }

    private void UIXImplement(){
        classmauapa = findViewById(R.id.classmauapa);
        classmakan = findViewById(R.id.classmakanapan);
        classsnack = findViewById(R.id.classsnackapa);
        classbuah = findViewById(R.id.classbuahapa);
        classminum = findViewById(R.id.classminumapan);
        classactivity = findViewById(R.id.classaktivitasapa);
        classmood = findViewById(R.id.classmoodsedangapa);
        select = findViewById(R.id.select);
        select2 = findViewById(R.id.select2);
        cardmakan = findViewById(R.id.cardmakan);
        cardminum = findViewById(R.id.cardminum);
        cardsnack = findViewById(R.id.cardsnack);
        cardbuah = findViewById(R.id.cardbuah);
        cardactiv = findViewById(R.id.cardctiv);
        cardmood = findViewById(R.id.cardmood);
        selected = findViewById(R.id.selected);
        nexteoke = findViewById(R.id.nexteoke);

        ha =" apa?";
        cardmakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardA(cardmakan,classmakan,R.drawable.eat, " Makan");
            }
        });

        cardsnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardA(cardsnack,classsnack,R.drawable.snack, " Makan Snack");
            }
        });

        cardbuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardA(cardbuah,classbuah,R.drawable.fruit, " Makan Buah");
            }
        });

        cardminum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardA(cardminum,classminum,R.drawable.drink, " Minum");
            }
        });

        cardactiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardA(cardactiv,classactivity,R.drawable.activ, " ");
            }
        });

        cardmood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardmakan.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                cardminum.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                cardbuah.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                cardsnack.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                cardactiv.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                cardmood.setCardBackgroundColor(getResources().getColor(R.color.green));
                fadeInView(selected);
                classmauapa.setVisibility(View.GONE);
                fadeInView(classmood);
                selectnew="Saya Sedang";
                select.setText(selectnew+ha);
            }
        });

        nexteoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
    private void makanapa(){
        cardnaskun = findViewById(R.id.cardnasikuning);
        cardnasgor = findViewById(R.id.cardnasigoreng);
        cardsayur = findViewById(R.id.cardsayur);
        cardayamgor = findViewById(R.id.cardayamgoreng);
        cardikangor = findViewById(R.id.cardikangoreng);
        cardayambak = findViewById(R.id.cardayambakar);
        cardikanbak = findViewById(R.id.cardikanbakar);
        cardnugget = findViewById(R.id.cardnugget);
        cardsosiss = findViewById(R.id.cardSosiss);
        resetmakan = findViewById(R.id.resetmakan);
        ambilmakan = findViewById(R.id.ambilmakan);

        cardnaskun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakan(cardnaskun, " Nasi Kuning", R.drawable.naskun);
            }
        });
        cardnasgor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakan(cardnasgor, " Nasi Goreng", R.drawable.nasgor);
            }
        });
        cardsayur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakan(cardsayur, " Sayur", R.drawable.sayur);
            }
        });
        cardayamgor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakan(cardayamgor, " Ayam Goreng", R.drawable.ayamgoreng);
            }
        });
        cardikangor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakan(cardikangor, " Ikan Goreng", R.drawable.ikangoreng);
            }
        });
        cardayambak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakan(cardayambak, " Ayam Bakar", R.drawable.ayambakar);
            }
        });
        cardikanbak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakan(cardikanbak, " Ikan Bakar", R.drawable.ikanbakar);
            }
        });
        cardnugget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakan(cardnugget, " Nugget", R.drawable.nugget);
            }
        });
        cardsosiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakan(cardsosiss, " Sosiss", R.drawable.sosiss);
            }
        });

        resetmakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeInView(classmauapa);
                PickupResetCardBackgrounds(classmakan, cardmakan,
                        cardnaskun, cardnasgor, cardsayur, cardayamgor,
                        cardikangor, cardayambak, cardikanbak, cardnugget,
                        cardsosiss);
                select.setText("Salah Pilih Ya tadi..? ");
            }
        });
        ambilmakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickupResetCardBackgrounds(ambilmakan, cardmakan,
                        cardnaskun, cardnasgor, cardsayur, cardayamgor,
                        cardikangor, cardayambak, cardikanbak, cardnugget,
                        cardsosiss);
                uixressults(resetmakan,ambilmakan,makanannya,selectnew+resultseletcnew);
            }
        });
    }

    private void makansnack(){
        cardroti = findViewById(R.id.cardroti);
        cardpuding = findViewById(R.id.cardpudding);
        cardwafer = findViewById(R.id.cardwafer);
        cardkeripik = findViewById(R.id.cardkripik);
        cardkentang = findViewById(R.id.cardkentanggoreng);
        cardchiki = findViewById(R.id.cardchiki);
        resetsnack = findViewById(R.id.resetsnack);
        ambilsnack = findViewById(R.id.ambilsnack);

        cardroti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanSnack(cardroti, " Roti", R.drawable.roti);
            }
        });
        cardpuding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanSnack(cardpuding, " Puding", R.drawable.pudding);
            }
        });
        cardwafer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanSnack(cardwafer, " Wafer", R.drawable.wafer);
            }
        });
        cardkeripik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanSnack(cardkeripik, " Keripik", R.drawable.kripik);
            }
        });
        cardkentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanSnack(cardkentang, " Kentang Goreng", R.drawable.kentanggoreng);
            }
        });
        cardchiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanSnack(cardchiki, " Chiki", R.drawable.chiki);
            }
        });

        resetsnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeInView(classmauapa);
                PickupResetCardBackgrounds(classsnack, cardroti,cardpuding,cardwafer,cardkeripik,cardkentang,cardchiki);
                select.setText("Salah Pilih Ya tadi..? ");
            }
        });
        ambilsnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickupResetCardBackgrounds(ambilsnack, cardroti,cardpuding,cardwafer,cardkeripik,cardkentang,cardchiki);
                uixressults(resetsnack,ambilsnack,makanannya,selectnew+resultseletcnew);
            }
        });
    }
    private void makanbuah(){
        cardalpukat = findViewById(R.id.cardalpukat);
        cardanggur = findViewById(R.id.cardanggur);
        cardapel = findViewById(R.id.cardapel);
        cardblimbing = findViewById(R.id.cardbelimbing);
        cardbluebery = findViewById(R.id.cardblueberry);
        carddurian = findViewById(R.id.carddurian);
        cardjambu = findViewById(R.id.cardjambu);
        cardjeruk = findViewById(R.id.cardjeruk);
        cardklengkeng = findViewById(R.id.cardkelengkeng);
        cardmangga = findViewById(R.id.cardmangga);
        cardmanggis = findViewById(R.id.cardmanggis);
        cardmelon = findViewById(R.id.cardmelon);
        cardpisang = findViewById(R.id.cardpisang);
        cardrambutan = findViewById(R.id.cardrambutan);
        resetbuah = findViewById(R.id.resetbuah);
        ambilbuah = findViewById(R.id.ambilbuah);

        cardalpukat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardalpukat, " Alpukat", R.drawable.alpukat);
            }
        });
        cardanggur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardanggur, " Anggur", R.drawable.anggur);
            }
        });

        cardapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardapel, " Apel", R.drawable.apel);
            }
        });

        cardblimbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardblimbing, " Belimbing", R.drawable.belimbing);
            }
        });

        cardbluebery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardbluebery, " Blueberry", R.drawable.blueberry);
            }
        });

        carddurian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(carddurian, " Durian", R.drawable.durian);
            }
        });

        cardjambu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardjambu, " Jambu", R.drawable.jambu);
            }
        });

        cardjeruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardjeruk, " Jeruk", R.drawable.jeruk);
            }
        });

        cardklengkeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardklengkeng, " Kelengkeng", R.drawable.kelengkeng);
            }
        });

        cardmangga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardmangga, " Mangga", R.drawable.mangga);
            }
        });

        cardmanggis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardmanggis, " Manggis", R.drawable.manggis);
            }
        });

        cardmelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardmelon, " Melon", R.drawable.melon);
            }
        });

        cardpisang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardpisang, " Pisang", R.drawable.pisang);
            }
        });

        cardrambutan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMakanBuah(cardrambutan, " Rambutan", R.drawable.rambuttan);
            }
        });

        resetbuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeInView(classmauapa);
                PickupResetCardBackgrounds(classbuah, cardalpukat,cardanggur,cardapel,cardblimbing,cardbluebery,carddurian,
                        cardjambu,cardjeruk,cardklengkeng,cardmangga,cardmanggis,cardmelon,cardpisang,cardrambutan);
                select.setText("Salah Pilih Ya tadi..? ");
            }
        });
        ambilbuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickupResetCardBackgrounds(ambilbuah, cardalpukat,cardanggur,cardapel,cardblimbing,cardbluebery,carddurian,
                        cardjambu,cardjeruk,cardklengkeng,cardmangga,cardmanggis,cardmelon,cardpisang,cardrambutan);
                uixressults(resetbuah,ambilbuah,makanannya,selectnew+resultseletcnew);
            }
        });
    }
    private void minumapa(){
        cardsusu = findViewById(R.id.cardsusu);
        cardairmineral = findViewById(R.id.cardairmineral);
        cardteh = findViewById(R.id.cardteh);
        cardjusjambu = findViewById(R.id.cardjusjambu);
        cardjusjeruk = findViewById(R.id.cardjusjeruk);
        cardjusalpukat = findViewById(R.id.cardjusalpukat);
        cardjusapel = findViewById(R.id.cardjusapel);
        resetminum = findViewById(R.id.resetminum);
        ambilminum = findViewById(R.id.ambilminum);

        cardsusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMinum(cardsusu, " Susu", R.drawable.susu);
            }
        });

        cardairmineral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMinum(cardairmineral, " Air Mineral", R.drawable.airmineral);
            }
        });

        cardteh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMinum(cardteh, " Teh", R.drawable.tehh);
            }
        });

        cardjusjambu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMinum(cardjusjambu, " Jus Jambu", R.drawable.jusjambu);
            }
        });

        cardjusjeruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMinum(cardjusjeruk, " Jus Jeruk", R.drawable.jusjeruk);
            }
        });

        cardjusalpukat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMinum(cardjusalpukat, " Jus Alpukat", R.drawable.jusalpukat);
            }
        });

        cardjusapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardMinum(cardjusapel, " Jus Apel", R.drawable.jusapell);
            }
        });

        resetminum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeInView(classmauapa);
                PickupResetCardBackgrounds(classminum, cardsusu,
                        cardairmineral, cardteh, cardjusjambu, cardjusjeruk,
                        cardjusalpukat, cardjusapel);
                select.setText("Salah Pilih Ya tadi..? ");
            }
        });
        ambilminum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickupResetCardBackgrounds(ambilminum, cardsusu,
                        cardairmineral, cardteh, cardjusjambu, cardjusjeruk,
                        cardjusalpukat, cardjusapel);
                uixressults(resetminum,ambilminum,minumannya,selectnew+resultseletcnew);
            }
        });

    }
    private void aktifitasapa(){
        cardbelajar = findViewById(R.id.cardbelajar);
        cardbermain = findViewById(R.id.cardbermain);
        cardberibadah = findViewById(R.id.cardberibadah);
        cardtidur = findViewById(R.id.cardtidur);
        cardmandi = findViewById(R.id.cardmandi);
        cardpipis = findViewById(R.id.cardbuangkecil);
        cardberak = findViewById(R.id.cardbuanbesar);
        resetaktifitas = findViewById(R.id.resetaktifitas);
        ambilaktifitas = findViewById(R.id.ambilaktifitas);

        cardbelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardActivity(cardbelajar, " Belajar", R.drawable.belajar);
            }
        });

        cardbermain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardActivity(cardbermain, " Bermain", R.drawable.bermain);
            }
        });

        cardberibadah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardActivity(cardberibadah, " Beribadah", R.drawable.beribadah);
            }
        });

        cardtidur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardActivity(cardtidur, " Tidur", R.drawable.tidur);
            }
        });

        cardmandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardActivity(cardmandi, " Mandi", R.drawable.mandi);
            }
        });

        cardpipis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardActivity(cardpipis, " Buang Air Kecil", R.drawable.buangairkecil);
            }
        });

        cardberak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCardActivity(cardberak, " Buang Air Besar", R.drawable.buangairbesar);
            }
        });

        resetaktifitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeInView(classmauapa);
                PickupResetCardBackgrounds(classactivity, cardbelajar,cardbermain,cardberibadah,cardtidur,cardmandi,cardpipis,cardberak);
                select.setText("Salah Pilih Ya tadi..? ");
            }
        });
        ambilaktifitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickupResetCardBackgrounds(ambilaktifitas, cardbelajar,cardbermain,cardberibadah,cardtidur,cardmandi,cardpipis,cardberak);
                uixressults(resetaktifitas,ambilaktifitas,aktifitasnya,selectnew+resultseletcnew);
            }
        });

    }
    private void sedangmood(){
        cardsenang = findViewById(R.id.cardsenang);
        cardsedih = findViewById(R.id.cardsedih);
        cardmarah = findViewById(R.id.cardmarah);;
        resetmood = findViewById(R.id.resetmood);
        ambilmood = findViewById(R.id.ambilmood);

        cardsenang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emm=1;
                onClickCardMood(cardsenang, " Senang.!!", R.drawable.senang);
            }
        });

        cardsedih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emm=2;
                onClickCardMood(cardsedih, " Sedih..", R.drawable.sedih);
            }
        });

        cardmarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emm=3;
                onClickCardMood(cardmarah, " Marah..!!", R.drawable.marah);
            }
        });

        resetmood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeInView(classmauapa);
                PickupResetCardBackgrounds(classmood, cardsenang,cardsedih,cardmarah);
                select.setText("Gajadi mengekspresikan nih..? ");
            }
        });
        ambilmood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickupResetCardBackgrounds(ambilmood, cardsenang,cardsedih,cardmarah);
                uixressultsmood(resetmood,ambilmood,emm,moodnya,selectnew+resultseletcnew);
            }
        });

    }
    public void uixressults(final View view,final View view2,Drawable drw,String hasilnya){
        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = textToSpeech.setLanguage(Locale.getDefault());

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(MainActivity.this, "Bahasa tidak didukung", Toast.LENGTH_SHORT).show();
                } else {
                    textToSpeech.speak(hasilnya, TextToSpeech.QUEUE_FLUSH, null, "ID");
                }
            } else {
                Toast.makeText(MainActivity.this, "TTS gagal diinisialisasi", Toast.LENGTH_SHORT).show();
            }
        });
        final LinearLayout classressult = findViewById(R.id.classresults);
        final LinearLayout resetressults = findViewById(R.id.resetressults);
        final ImageView imageress = findViewById(R.id.imageresult);
        final TextView textresul = findViewById(R.id.textresult);
        selected.setVisibility(View.INVISIBLE);
        classmakan.setVisibility(View.GONE);
        classsnack.setVisibility(View.GONE);
        classbuah.setVisibility(View.GONE);
        classminum.setVisibility(View.GONE);
        classactivity.setVisibility(View.GONE);
        classmood.setVisibility(View.GONE);
        fadeInView(classressult);
        PopupDialog.getInstance(this)
                .setStyle(Styles.LOTTIE_ANIMATION)
                .setLottieRawRes(R.raw.cgrts)
                .setLottieDialogTimeout(2500)
                .setCancelable(false)
                .showDialog();
        imageress.setImageDrawable(drw);
        textresul.setText(hasilnya);
        resetressults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Ayo kita lakukan lagi!!")
                        .setConfirmText("Ayo")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                classressult.setVisibility(View.GONE);
                                view.setVisibility(View.VISIBLE);
                                view2.setVisibility(View.GONE);
                                fadeInView(classmauapa);
                                fadeInView(selected);
                                select.setText("Ayoo apalagi..? ");
                                sDialog.dismiss();
                            }
                        }).show();
            }
        });
    }
    public void uixressultsmood(final View view,final View view2,int keberapa,Drawable drw,String hasilnya){
        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = textToSpeech.setLanguage(Locale.getDefault());

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(MainActivity.this, "Bahasa tidak didukung", Toast.LENGTH_SHORT).show();
                } else {
                    textToSpeech.speak(hasilnya, TextToSpeech.QUEUE_FLUSH, null, "ID");
                }
            } else {
                Toast.makeText(MainActivity.this, "TTS gagal diinisialisasi", Toast.LENGTH_SHORT).show();
            }
        });
        final LinearLayout classressult = findViewById(R.id.classresults);
        final LinearLayout resetressults = findViewById(R.id.resetressults);
        final ImageView imageress = findViewById(R.id.imageresult);
        final TextView textresul = findViewById(R.id.textresult);
        selected.setVisibility(View.INVISIBLE);
        classmakan.setVisibility(View.GONE);
        classsnack.setVisibility(View.GONE);
        classbuah.setVisibility(View.GONE);
        classminum.setVisibility(View.GONE);
        classactivity.setVisibility(View.GONE);
        classmood.setVisibility(View.GONE);
        fadeInView(classressult);

        if(keberapa==1) {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.LOTTIE_ANIMATION)
                    .setLottieRawRes(R.raw.happy)
                    .setLottieDialogTimeout(2500)
                    .setCancelable(false)
                    .showDialog();
        }
        if(keberapa==2) {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.LOTTIE_ANIMATION)
                    .setLottieRawRes(R.raw.sad)
                    .setLottieDialogTimeout(2500)
                    .setCancelable(false)
                    .showDialog();
        }
        if(keberapa==3) {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.LOTTIE_ANIMATION)
                    .setLottieRawRes(R.raw.angry)
                    .setLottieDialogTimeout(2500)
                    .setCancelable(false)
                    .showDialog();
        }

        imageress.setImageDrawable(drw);
        textresul.setText(hasilnya);
        resetressults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Ayo ulangi lagi!!")
                        .setConfirmText("Ayo")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                classressult.setVisibility(View.GONE);
                                view.setVisibility(View.VISIBLE);
                                view2.setVisibility(View.GONE);
                                fadeInView(classmauapa);
                                fadeInView(selected);
                                select.setText("Ayoo apalagi..? ");
                                sDialog.dismiss();
                            }
                        }).show();
            }
        });
    }
    private void fadeInView(final View view) {
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1000);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(fadeIn);
    }
    private void fadeInViewgone(final View view) {
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1000);
        view.setVisibility(View.GONE);
        view.startAnimation(fadeIn);
    }
    @Override
    public void onBackPressed() {
        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Kamu Ingin Keluar?")
                .setCancelText("Ulang aja")
                .setConfirmText("Iya Nih")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        sDialog.dismiss();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        finishAffinity();
                        sDialog.dismiss();
                    }
                }).show();
    }

    public void UIXBaruLogin(){
        Uri imageUri = Uri.parse(LoginActivity.imageUri);
        imageonmain = findViewById(R.id.imageonmain);
        imagedit = findViewById(R.id.imagedit);
        editing = false;
        imagedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Beneran mau ngedit profile?")
                        .setCancelText("Tidak")
                        .setConfirmText("Iyaa")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismiss();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                editing = true;
                                prefs.write(LoginActivity.USER, "");
                                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                            }
                        }).show();
            }
        });
        try {
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            Drawable customImageDrawable = Drawable.createFromStream(inputStream, imageUri.toString());
            imageonmain.setImageDrawable(customImageDrawable);
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setCustomImage(customImageDrawable)
                    .setTitleText("Selamat Datang " + USERKEY)
                    .setConfirmText("Lanjut")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    }).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void PickupResetCardBackgrounds(final View view,CardView... cards) {
        for (CardView card : cards) {
            card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
        view.setVisibility(View.GONE);
    }

    public void onClickCardA(final CardView card,final View classnya, final int imageResource, final String title) {
        cardmakan.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        cardminum.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        cardsnack.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        cardbuah.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        cardactiv.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        cardmood.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));

        card.setCardBackgroundColor(getResources().getColor(R.color.green));
        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setCustomImage(imageResource)
                .setTitleText("Kamu sudah "+title+"?")
                .setCancelText("Belum")
                .setConfirmText("Sudah")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        fadeInView(selected);
                        fadeInViewgone(classmauapa);
                        fadeInView(classnya);
                        selectnew = "Saya akan " + title;
                        select.setText(selectnew + ha);
                        card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        sDialog.dismiss();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        fadeInView(selected);
                        fadeInViewgone(classmauapa);
                        fadeInView(classnya);
                        selectnew = "Saya sudah " + title;
                        select.setText(selectnew + ha);
                        card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        sDialog.dismiss();
                    }
                })
                .show();
    }
    public void onClickCardMakan(final CardView clickedCard, final String foodName, final int imageResource) {
        CardView[] allCards = {cardnaskun, cardnasgor, cardsayur, cardayamgor, cardikangor, cardayambak, cardikanbak, cardnugget, cardsosiss};

        for (CardView card : allCards) {
            card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        clickedCard.setCardBackgroundColor(getResources().getColor(R.color.green));

        fadeInView(selected);
        resetmakan.setVisibility(View.GONE);
        fadeInView(ambilmakan);

        resultseletcnew = foodName;
        select.setText(selectnew + resultseletcnew);

        makanannya = getResources().getDrawable(imageResource);
    }
    public void onClickCardMakanSnack(final CardView clickedCard, final String foodName, final int imageResource) {
        CardView[] allCards = {cardroti,cardpuding,cardwafer,cardkeripik,cardkentang,cardchiki};

        for (CardView card : allCards) {
            card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        clickedCard.setCardBackgroundColor(getResources().getColor(R.color.green));

        fadeInView(selected);
        resetsnack.setVisibility(View.GONE);
        fadeInView(ambilsnack);

        resultseletcnew = foodName;
        select.setText(selectnew + resultseletcnew);

        makanannya = getResources().getDrawable(imageResource);
    }
    public void onClickCardMakanBuah(final CardView clickedCard, final String foodName, final int imageResource) {
        CardView[] allCards = {cardalpukat,cardanggur,cardapel,cardblimbing,cardbluebery,carddurian,
                cardjambu,cardjeruk,cardklengkeng,cardmangga,cardmanggis,cardmelon,cardpisang,cardrambutan};

        for (CardView card : allCards) {
            card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        clickedCard.setCardBackgroundColor(getResources().getColor(R.color.green));

        fadeInView(selected);
        resetbuah.setVisibility(View.GONE);
        fadeInView(ambilbuah);

        resultseletcnew = foodName;
        select.setText(selectnew + resultseletcnew);

        makanannya = getResources().getDrawable(imageResource);
    }
    public void onClickCardMinum(final CardView clickedCard, final String drinkName, final int imageResource) {
        CardView[] allCards = {cardsusu, cardairmineral, cardteh, cardjusjambu, cardjusjeruk, cardjusalpukat, cardjusapel};

        for (CardView card : allCards) {
            card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        clickedCard.setCardBackgroundColor(getResources().getColor(R.color.green));

        fadeInView(selected);
        resetminum.setVisibility(View.GONE);
        fadeInView(ambilminum);

        resultseletcnew = drinkName;
        select.setText(selectnew + resultseletcnew);

        minumannya = getResources().getDrawable(imageResource);
    }
    public void onClickCardActivity(final CardView clickedCard, final String activityName, final int imageResource) {
        CardView[] allCards = {cardbelajar,cardbermain,cardberibadah,cardtidur,cardmandi,cardpipis,cardberak};

        for (CardView card : allCards) {
            card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        clickedCard.setCardBackgroundColor(getResources().getColor(R.color.green));

        fadeInView(selected);
        resetaktifitas.setVisibility(View.GONE);
        fadeInView(ambilaktifitas);

        resultseletcnew = activityName;
        select.setText(selectnew + resultseletcnew);

        aktifitasnya = getResources().getDrawable(imageResource);
    }
        public void onClickCardMood(final CardView clickedCard, final String activityName, final int imageResource) {
        CardView[] allCards = {cardmood,cardsenang,cardsedih,cardmarah};

        for (CardView card : allCards) {
            card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        clickedCard.setCardBackgroundColor(getResources().getColor(R.color.green));

        fadeInView(selected);
        resetmood.setVisibility(View.GONE);
        fadeInView(ambilmood);

        resultseletcnew = activityName;
        select.setText(selectnew + resultseletcnew);

        moodnya = getResources().getDrawable(imageResource);
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }


}
