package com.example.p8_app;

/*import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.analytics.FirebaseAnalytics;

public class ProductsFragment extends Fragment {

    FirebaseAnalytics analytics;
    FirebaseAnalytics mFirebaseAnalytics;
    Bundle item;
    String name;
    String text;

    private Button increase;
    private Button increase2;
    private Button decrease;
    private Button decrease2;

    private Object Context;
        /*Connect buttons to XML file
        increase =findViewById(R.id.increase);
        increase2 =findViewById(R.id.increase2);
        decrease =findViewById(R.id.decrease);
        decrease2 =findViewById(R.id.decrease2);*/


       /* @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                        return inflater.inflate(R.layout.fragment_products, container, false);

        /*Database items*/
            /*Bundle itemAgurk = new Bundle();
            itemAgurk.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
            itemAgurk.putString(FirebaseAnalytics.Param.ITEM_NAME, "agurk");
            itemAgurk.putDouble(FirebaseAnalytics.Param.PRICE, 8.00);
            itemAgurk.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemAsparges = new Bundle();
            itemAsparges.putString(FirebaseAnalytics.Param.ITEM_ID, "2");
            itemAsparges.putString(FirebaseAnalytics.Param.ITEM_NAME, "asparges");
            itemAsparges.putDouble(FirebaseAnalytics.Param.PRICE, 28.00);
            itemAsparges.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBasilikum = new Bundle();
            itemBasilikum.putString(FirebaseAnalytics.Param.ITEM_ID, "3");
            itemBasilikum.putString(FirebaseAnalytics.Param.ITEM_NAME, "basilikum");
            itemBasilikum.putDouble(FirebaseAnalytics.Param.PRICE, 12.00);
            itemBasilikum.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBladselleri = new Bundle();
            itemBladselleri.putString(FirebaseAnalytics.Param.ITEM_ID, "4");
            itemBladselleri.putString(FirebaseAnalytics.Param.ITEM_NAME, "bladselleri");
            itemBladselleri.putDouble(FirebaseAnalytics.Param.PRICE, 13.00);
            itemBladselleri.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBlomkål = new Bundle();
            itemBlomkål.putString(FirebaseAnalytics.Param.ITEM_ID, "5");
            itemBlomkål.putString(FirebaseAnalytics.Param.ITEM_NAME, "blomkål");
            itemBlomkål.putDouble(FirebaseAnalytics.Param.PRICE, 19.00);
            itemBlomkål.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBlommer = new Bundle();
            itemBlommer.putString(FirebaseAnalytics.Param.ITEM_ID, "6");
            itemBlommer.putString(FirebaseAnalytics.Param.ITEM_NAME, "blommer");
            itemBlommer.putDouble(FirebaseAnalytics.Param.PRICE, 2.50);
            itemBlommer.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBlåbær = new Bundle();
            itemBlåbær.putString(FirebaseAnalytics.Param.ITEM_ID, "7");
            itemBlåbær.putString(FirebaseAnalytics.Param.ITEM_NAME, "blåbær");
            itemBlåbær.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemBlåbær.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBroccoli = new Bundle();
            itemBroccoli.putString(FirebaseAnalytics.Param.ITEM_ID, "8");
            itemBroccoli.putString(FirebaseAnalytics.Param.ITEM_NAME, "broccoli");
            itemBroccoli.putDouble(FirebaseAnalytics.Param.PRICE, 14.00);
            itemBroccoli.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBrombær = new Bundle();
            itemBrombær.putString(FirebaseAnalytics.Param.ITEM_ID, "9");
            itemBrombær.putString(FirebaseAnalytics.Param.ITEM_NAME, "brombær");
            itemBrombær.putDouble(FirebaseAnalytics.Param.PRICE, 22.00);
            itemBrombær.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBøgehat = new Bundle();
            itemBøgehat.putString(FirebaseAnalytics.Param.ITEM_ID, "10");
            itemBøgehat.putString(FirebaseAnalytics.Param.ITEM_NAME, "bøgehat");
            itemBøgehat.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemBøgehat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemGrønneBønner = new Bundle();
            itemGrønneBønner.putString(FirebaseAnalytics.Param.ITEM_ID, "11");
            itemGrønneBønner.putString(FirebaseAnalytics.Param.ITEM_NAME, "grønne_bønner");
            itemGrønneBønner.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemGrønneBønner.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemChampignon = new Bundle();
            itemChampignon.putString(FirebaseAnalytics.Param.ITEM_ID, "12");
            itemChampignon.putString(FirebaseAnalytics.Param.ITEM_NAME, "champignon");
            itemChampignon.putDouble(FirebaseAnalytics.Param.PRICE, 16.00);
            itemChampignon.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemChilli = new Bundle();
            itemChilli.putString(FirebaseAnalytics.Param.ITEM_ID, "13");
            itemChilli.putString(FirebaseAnalytics.Param.ITEM_NAME, "chilli");
            itemChilli.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemChilli.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemCitronmelisse = new Bundle();
            itemCitronmelisse.putString(FirebaseAnalytics.Param.ITEM_ID, "14");
            itemCitronmelisse.putString(FirebaseAnalytics.Param.ITEM_NAME, "citronmelisse");
            itemCitronmelisse.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemCitronmelisse.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemDild = new Bundle();
            itemDild.putString(FirebaseAnalytics.Param.ITEM_ID, "15");
            itemDild.putString(FirebaseAnalytics.Param.ITEM_NAME, "dild");
            itemDild.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemDild.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemEstragon = new Bundle();
            itemEstragon.putString(FirebaseAnalytics.Param.ITEM_ID, "16");
            itemEstragon.putString(FirebaseAnalytics.Param.ITEM_NAME, "estragon");
            itemEstragon.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemEstragon.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemFeldsalat = new Bundle();
            itemFeldsalat.putString(FirebaseAnalytics.Param.ITEM_ID, "17");
            itemFeldsalat.putString(FirebaseAnalytics.Param.ITEM_NAME, "feldsalat");
            itemFeldsalat.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemFeldsalat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemFenikkel = new Bundle();
            itemFenikkel.putString(FirebaseAnalytics.Param.ITEM_ID, "18");
            itemFenikkel.putString(FirebaseAnalytics.Param.ITEM_NAME, "fenikkel");
            itemFenikkel.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemFenikkel.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemForårsløg = new Bundle();
            itemForårsløg.putString(FirebaseAnalytics.Param.ITEM_ID, "19");
            itemForårsløg.putString(FirebaseAnalytics.Param.ITEM_NAME, "forårsløg");
            itemForårsløg.putDouble(FirebaseAnalytics.Param.PRICE, 6.00);
            itemForårsløg.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemGlaskål = new Bundle();
            itemGlaskål.putString(FirebaseAnalytics.Param.ITEM_ID, "20");
            itemGlaskål.putString(FirebaseAnalytics.Param.ITEM_NAME, "glaskål");
            itemGlaskål.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemGlaskål.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemGrønkål = new Bundle();
            itemGrønkål.putString(FirebaseAnalytics.Param.ITEM_ID, "21");
            itemGrønkål.putString(FirebaseAnalytics.Param.ITEM_NAME, "grønkål");
            itemGrønkål.putDouble(FirebaseAnalytics.Param.PRICE, 22.00);
            itemGrønkål.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemFarvetGulerod = new Bundle();
            itemFarvetGulerod.putString(FirebaseAnalytics.Param.ITEM_ID, "22");
            itemFarvetGulerod.putString(FirebaseAnalytics.Param.ITEM_NAME, "farvet_gulerod");
            itemFarvetGulerod.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemFarvetGulerod.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemGulerødder = new Bundle();
            itemGulerødder.putString(FirebaseAnalytics.Param.ITEM_ID, "23");
            itemGulerødder.putString(FirebaseAnalytics.Param.ITEM_NAME, "gulerødder");
            itemGulerødder.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemGulerødder.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemHindbær = new Bundle();
            itemHindbær.putString(FirebaseAnalytics.Param.ITEM_ID, "24");
            itemHindbær.putString(FirebaseAnalytics.Param.ITEM_NAME, "hindbær");
            itemHindbær.putDouble(FirebaseAnalytics.Param.PRICE, 22.00);
            itemHindbær.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemHjertesalat = new Bundle();
            itemHjertesalat.putString(FirebaseAnalytics.Param.ITEM_ID, "25");
            itemHjertesalat.putString(FirebaseAnalytics.Param.ITEM_NAME, "hjertesalat");
            itemHjertesalat.putDouble(FirebaseAnalytics.Param.PRICE, 12.00);
            itemHjertesalat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemHokkaido = new Bundle();
            itemHokkaido.putString(FirebaseAnalytics.Param.ITEM_ID, "26");
            itemHokkaido.putString(FirebaseAnalytics.Param.ITEM_NAME, "hokkaido");
            itemHokkaido.putDouble(FirebaseAnalytics.Param.PRICE, 25.00);
            itemHokkaido.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemHovedsalat = new Bundle();
            itemHovedsalat.putString(FirebaseAnalytics.Param.ITEM_ID, "27");
            itemHovedsalat.putString(FirebaseAnalytics.Param.ITEM_NAME, "hovedsalat");
            itemHovedsalat.putDouble(FirebaseAnalytics.Param.PRICE, 18.00);
            itemHovedsalat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemHvidkål = new Bundle();
            itemHvidkål.putString(FirebaseAnalytics.Param.ITEM_ID, "28");
            itemHvidkål.putString(FirebaseAnalytics.Param.ITEM_NAME, "hvidkål");
            itemHvidkål.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemHvidkål.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemIceberg = new Bundle();
            itemIceberg.putString(FirebaseAnalytics.Param.ITEM_ID, "29");
            itemIceberg.putString(FirebaseAnalytics.Param.ITEM_NAME, "iceberg");
            itemIceberg.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemIceberg.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemJordbær = new Bundle();
            itemJordbær.putString(FirebaseAnalytics.Param.ITEM_ID, "30");
            itemJordbær.putString(FirebaseAnalytics.Param.ITEM_NAME, "jordbær");
            itemJordbær.putDouble(FirebaseAnalytics.Param.PRICE, 25.00);
            itemJordbær.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemJordskokker = new Bundle();
            itemJordskokker.putString(FirebaseAnalytics.Param.ITEM_ID, "31");
            itemJordskokker.putString(FirebaseAnalytics.Param.ITEM_NAME, "jordskokker");
            itemJordskokker.putDouble(FirebaseAnalytics.Param.PRICE, 12.00);
            itemJordskokker.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemKejserhat = new Bundle();
            itemKejserhat.putString(FirebaseAnalytics.Param.ITEM_ID, "32");
            itemKejserhat.putString(FirebaseAnalytics.Param.ITEM_NAME, "kejserhat");
            itemKejserhat.putDouble(FirebaseAnalytics.Param.PRICE, 30.00);
            itemKejserhat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemKinakål = new Bundle();
            itemKinakål.putString(FirebaseAnalytics.Param.ITEM_ID, "33");
            itemKinakål.putString(FirebaseAnalytics.Param.ITEM_NAME, "kinakål");
            itemKinakål.putDouble(FirebaseAnalytics.Param.PRICE, 21.00);
            itemKinakål.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemKirsebær = new Bundle();
            itemKirsebær.putString(FirebaseAnalytics.Param.ITEM_ID, "34");
            itemKirsebær.putString(FirebaseAnalytics.Param.ITEM_NAME, "kirsebær");
            itemKirsebær.putDouble(FirebaseAnalytics.Param.PRICE, 25.00);
            itemKirsebær.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemKnoldselleri = new Bundle();
            itemKnoldselleri.putString(FirebaseAnalytics.Param.ITEM_ID, "35");
            itemKnoldselleri.putString(FirebaseAnalytics.Param.ITEM_NAME, "knoldselleri");
            itemKnoldselleri.putDouble(FirebaseAnalytics.Param.PRICE, 13.00);
            itemKnoldselleri.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemKoriander = new Bundle();
            itemKoriander.putString(FirebaseAnalytics.Param.ITEM_ID, "36");
            itemKoriander.putString(FirebaseAnalytics.Param.ITEM_NAME, "koriander");
            itemKoriander.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemKoriander.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemLøg = new Bundle();
            itemLøg.putString(FirebaseAnalytics.Param.ITEM_ID, "37");
            itemLøg.putString(FirebaseAnalytics.Param.ITEM_NAME, "løg");
            itemLøg.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemLøg.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemMajroe = new Bundle();
            itemMajroe.putString(FirebaseAnalytics.Param.ITEM_ID, "38");
            itemMajroe.putString(FirebaseAnalytics.Param.ITEM_NAME, "majroe");
            itemMajroe.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemMajroe.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemMajskolbe = new Bundle();
            itemMajskolbe.putString(FirebaseAnalytics.Param.ITEM_ID, "39");
            itemMajskolbe.putString(FirebaseAnalytics.Param.ITEM_NAME, "majskolbe");
            itemMajskolbe.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemMajskolbe.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemMerian = new Bundle();
            itemMerian.putString(FirebaseAnalytics.Param.ITEM_ID, "40");
            itemMerian.putString(FirebaseAnalytics.Param.ITEM_NAME, "merian");
            itemMerian.putDouble(FirebaseAnalytics.Param.PRICE, 16.00);
            itemMerian.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemMynte = new Bundle();
            itemMynte.putString(FirebaseAnalytics.Param.ITEM_ID, "41");
            itemMynte.putString(FirebaseAnalytics.Param.ITEM_NAME, "mynte");
            itemMynte.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemMynte.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemNetmelon = new Bundle();
            itemNetmelon.putString(FirebaseAnalytics.Param.ITEM_ID, "42");
            itemNetmelon.putString(FirebaseAnalytics.Param.ITEM_NAME, "netmelon");
            itemNetmelon.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemNetmelon.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemOregano = new Bundle();
            itemOregano.putString(FirebaseAnalytics.Param.ITEM_ID, "43");
            itemOregano.putString(FirebaseAnalytics.Param.ITEM_NAME, "oregano");
            itemOregano.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemOregano.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemPakChoy = new Bundle();
            itemPakChoy.putString(FirebaseAnalytics.Param.ITEM_ID, "44");
            itemPakChoy.putString(FirebaseAnalytics.Param.ITEM_NAME, "pak_choy");
            itemPakChoy.putDouble(FirebaseAnalytics.Param.PRICE, 29.00);
            itemPakChoy.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemPastinak = new Bundle();
            itemPastinak.putString(FirebaseAnalytics.Param.ITEM_ID, "45");
            itemPastinak.putString(FirebaseAnalytics.Param.ITEM_NAME, "pastinak");
            itemPastinak.putDouble(FirebaseAnalytics.Param.PRICE, 12.00);
            itemPastinak.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemPeberfrugt = new Bundle();
            itemPeberfrugt.putString(FirebaseAnalytics.Param.ITEM_ID, "46");
            itemPeberfrugt.putString(FirebaseAnalytics.Param.ITEM_NAME, "peberfrugt");
            itemPeberfrugt.putDouble(FirebaseAnalytics.Param.PRICE, 7.00);
            itemPeberfrugt.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemPeberrod = new Bundle();
            itemPeberrod.putString(FirebaseAnalytics.Param.ITEM_ID, "47");
            itemPeberrod.putString(FirebaseAnalytics.Param.ITEM_NAME, "peberrod");
            itemPeberrod.putDouble(FirebaseAnalytics.Param.PRICE, 17.00);
            itemPeberrod.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemPersille = new Bundle();
            itemPersille.putString(FirebaseAnalytics.Param.ITEM_ID, "48");
            itemPersille.putString(FirebaseAnalytics.Param.ITEM_NAME, "persille");
            itemPersille.putDouble(FirebaseAnalytics.Param.PRICE, 7.00);
            itemPersille.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemPorre = new Bundle();
            itemPorre.putString(FirebaseAnalytics.Param.ITEM_ID, "49");
            itemPorre.putString(FirebaseAnalytics.Param.ITEM_NAME, "porre");
            itemPorre.putDouble(FirebaseAnalytics.Param.PRICE, 18.00);
            itemPorre.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemPortobello = new Bundle();
            itemPortobello.putString(FirebaseAnalytics.Param.ITEM_ID, "50");
            itemPortobello.putString(FirebaseAnalytics.Param.ITEM_NAME, "portobello");
            itemPortobello.putDouble(FirebaseAnalytics.Param.PRICE, 25.00);
            itemPortobello.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemPurløg = new Bundle();
            itemPurløg.putString(FirebaseAnalytics.Param.ITEM_ID, "51");
            itemPurløg.putString(FirebaseAnalytics.Param.ITEM_NAME, "purløg");
            itemPurløg.putDouble(FirebaseAnalytics.Param.PRICE, 7.00);
            itemPurløg.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemPærer = new Bundle();
            itemPærer.putString(FirebaseAnalytics.Param.ITEM_ID, "52");
            itemPærer.putString(FirebaseAnalytics.Param.ITEM_NAME, "pærer");
            itemPærer.putDouble(FirebaseAnalytics.Param.PRICE, 2.50);
            itemPærer.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemRabarber = new Bundle();
            itemRabarber.putString(FirebaseAnalytics.Param.ITEM_ID, "53");
            itemRabarber.putString(FirebaseAnalytics.Param.ITEM_NAME, "rabarber");
            itemRabarber.putDouble(FirebaseAnalytics.Param.PRICE, 26.00);
            itemRabarber.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemRadiser = new Bundle();
            itemRadiser.putString(FirebaseAnalytics.Param.ITEM_ID, "54");
            itemRadiser.putString(FirebaseAnalytics.Param.ITEM_NAME, "radiser");
            itemRadiser.putDouble(FirebaseAnalytics.Param.PRICE, 7.00);
            itemRadiser.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemRibs = new Bundle();
            itemRibs.putString(FirebaseAnalytics.Param.ITEM_ID, "55");
            itemRibs.putString(FirebaseAnalytics.Param.ITEM_NAME, "ribs");
            itemRibs.putDouble(FirebaseAnalytics.Param.PRICE, 32.00);
            itemRibs.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemRosenkål = new Bundle();
            itemRosenkål.putString(FirebaseAnalytics.Param.ITEM_ID, "56");
            itemRosenkål.putString(FirebaseAnalytics.Param.ITEM_NAME, "rosenkål");
            itemRosenkål.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemRosenkål.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemRosmarin = new Bundle();
            itemRosmarin.putString(FirebaseAnalytics.Param.ITEM_ID, "57");
            itemRosmarin.putString(FirebaseAnalytics.Param.ITEM_NAME, "rosmarin");
            itemRosmarin.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemRosmarin.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemRucola = new Bundle();
            itemRucola.putString(FirebaseAnalytics.Param.ITEM_ID, "58");
            itemRucola.putString(FirebaseAnalytics.Param.ITEM_NAME, "rucola");
            itemRucola.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemRucola.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemRødbede = new Bundle();
            itemRødbede.putString(FirebaseAnalytics.Param.ITEM_ID, "59");
            itemRødbede.putString(FirebaseAnalytics.Param.ITEM_NAME, "rødbede");
            itemRødbede.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemRødbede.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemRødkål = new Bundle();
            itemRødkål.putString(FirebaseAnalytics.Param.ITEM_ID, "60");
            itemRødkål.putString(FirebaseAnalytics.Param.ITEM_NAME, "rødkål");
            itemRødkål.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemRødkål.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemRødløg = new Bundle();
            itemRødløg.putString(FirebaseAnalytics.Param.ITEM_ID, "61");
            itemRødløg.putString(FirebaseAnalytics.Param.ITEM_NAME, "rødløg");
            itemRødløg.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemRødløg.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSalvie = new Bundle();
            itemSalvie.putString(FirebaseAnalytics.Param.ITEM_ID, "62");
            itemSalvie.putString(FirebaseAnalytics.Param.ITEM_NAME, "salvie");
            itemSalvie.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemSalvie.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSavoykål = new Bundle();
            itemSavoykål.putString(FirebaseAnalytics.Param.ITEM_ID, "63");
            itemSavoykål.putString(FirebaseAnalytics.Param.ITEM_NAME, "savoykål");
            itemSavoykål.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemSavoykål.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemShiitake = new Bundle();
            itemShiitake.putString(FirebaseAnalytics.Param.ITEM_ID, "64");
            itemShiitake.putString(FirebaseAnalytics.Param.ITEM_NAME, "shiitake");
            itemShiitake.putDouble(FirebaseAnalytics.Param.PRICE, 30.00);
            itemShiitake.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSkalotteløg = new Bundle();
            itemSkalotteløg.putString(FirebaseAnalytics.Param.ITEM_ID, "65");
            itemSkalotteløg.putString(FirebaseAnalytics.Param.ITEM_NAME, "skalotteløg");
            itemSkalotteløg.putDouble(FirebaseAnalytics.Param.PRICE, 12.00);
            itemSkalotteløg.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSolbær = new Bundle();
            itemSolbær.putString(FirebaseAnalytics.Param.ITEM_ID, "66");
            itemSolbær.putString(FirebaseAnalytics.Param.ITEM_NAME, "solbær");
            itemSolbær.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemSolbær.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSpidskål = new Bundle();
            itemSpidskål.putString(FirebaseAnalytics.Param.ITEM_ID, "67");
            itemSpidskål.putString(FirebaseAnalytics.Param.ITEM_NAME, "spidskål");
            itemSpidskål.putDouble(FirebaseAnalytics.Param.PRICE, 13.00);
            itemSpidskål.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSpinat = new Bundle();
            itemSpinat.putString(FirebaseAnalytics.Param.ITEM_ID, "68");
            itemSpinat.putString(FirebaseAnalytics.Param.ITEM_NAME, "spinat");
            itemSpinat.putDouble(FirebaseAnalytics.Param.PRICE, 22.00);
            itemSpinat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSpirer = new Bundle();
            itemSpirer.putString(FirebaseAnalytics.Param.ITEM_ID, "69");
            itemSpirer.putString(FirebaseAnalytics.Param.ITEM_NAME, "spirer");
            itemSpirer.putDouble(FirebaseAnalytics.Param.PRICE, 12.00);
            itemSpirer.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSquash = new Bundle();
            itemSquash.putString(FirebaseAnalytics.Param.ITEM_ID, "70");
            itemSquash.putString(FirebaseAnalytics.Param.ITEM_NAME, "squash");
            itemSquash.putDouble(FirebaseAnalytics.Param.PRICE, 8.00);
            itemSquash.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemStikkelsbær = new Bundle();
            itemStikkelsbær.putString(FirebaseAnalytics.Param.ITEM_ID, "71");
            itemStikkelsbær.putString(FirebaseAnalytics.Param.ITEM_NAME, "stikkelsbær");
            itemStikkelsbær.putDouble(FirebaseAnalytics.Param.PRICE, 32.00);
            itemStikkelsbær.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemTimian = new Bundle();
            itemTimian.putString(FirebaseAnalytics.Param.ITEM_ID, "72");
            itemTimian.putString(FirebaseAnalytics.Param.ITEM_NAME, "timian");
            itemTimian.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemTimian.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemTomat = new Bundle();
            itemTomat.putString(FirebaseAnalytics.Param.ITEM_ID, "73");
            itemTomat.putString(FirebaseAnalytics.Param.ITEM_NAME, "tomat");
            itemTomat.putDouble(FirebaseAnalytics.Param.PRICE, 2.00);
            itemTomat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemÆbler = new Bundle();
            itemÆbler.putString(FirebaseAnalytics.Param.ITEM_ID, "74");
            itemÆbler.putString(FirebaseAnalytics.Param.ITEM_NAME, "æbler");
            itemÆbler.putDouble(FirebaseAnalytics.Param.PRICE, 2.50);
            itemÆbler.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemÆrter = new Bundle();
            itemÆrter.putString(FirebaseAnalytics.Param.ITEM_ID, "75");
            itemÆrter.putString(FirebaseAnalytics.Param.ITEM_NAME, "ærter");
            itemÆrter.putDouble(FirebaseAnalytics.Param.PRICE, 12.00);
            itemÆrter.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemÆrteskud = new Bundle();
            itemÆrteskud.putString(FirebaseAnalytics.Param.ITEM_ID, "76");
            itemÆrteskud.putString(FirebaseAnalytics.Param.ITEM_NAME, "ærteskud");
            itemÆrteskud.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemÆrteskud.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemØstershat = new Bundle();
            itemØstershat.putString(FirebaseAnalytics.Param.ITEM_ID, "77");
            itemØstershat.putString(FirebaseAnalytics.Param.ITEM_NAME, "østershat");
            itemØstershat.putDouble(FirebaseAnalytics.Param.PRICE, 25.00);
            itemØstershat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            /*Select product from a list*/
            /*Bundle itemAgurkWithIndex = new Bundle(itemAgurk);
            itemAgurkWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 1);

            Bundle itemAspargesWithIndex = new Bundle(itemAsparges);
            itemAspargesWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 2);

            Bundle itemBasilikumWithIndex = new Bundle(itemBasilikum);
            itemBasilikumWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 3);

            Bundle itemBladselleriWithIndex = new Bundle(itemBladselleri);
            itemBladselleriWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 4);

            Bundle itemBlomkålWithIndex = new Bundle(itemBlomkål);
            itemBlomkålWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 5);

            Bundle itemBlommerWithIndex = new Bundle(itemBlommer);
            itemBlommerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 6);

            Bundle itemBlåbærWithIndex = new Bundle(itemBlåbær);
            itemBlåbærWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 7);

            Bundle itemBroccoliWithIndex = new Bundle(itemBroccoli);
            itemBroccoliWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 8);

            Bundle itemBrombærWithIndex = new Bundle(itemBrombær);
            itemBrombærWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 9);

            Bundle itemBøgehatWithIndex = new Bundle(itemBøgehat);
            itemBøgehatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 10);

            Bundle itemGrønneBønnerWithIndex = new Bundle(itemGrønneBønner);
            itemGrønneBønnerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 11);

            Bundle itemChampignonWithIndex = new Bundle(itemChampignon);
            itemChampignonWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 12);

            Bundle itemChilliWithIndex = new Bundle(itemChilli);
            itemChilliWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 13);

            Bundle itemCitronmelisseWithIndex = new Bundle(itemCitronmelisse);
            itemCitronmelisseWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 14);

            Bundle itemDildWithIndex = new Bundle(itemDild);
            itemDildWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 15);

            Bundle itemEstragonWithIndex = new Bundle(itemEstragon);
            itemEstragonWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 16);

            Bundle itemFeldsalatWithIndex = new Bundle(itemFeldsalat);
            itemFeldsalatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 17);

            Bundle itemFenikkelWithIndex = new Bundle(itemFenikkel);
            itemFenikkelWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 18);

            Bundle itemForårsløgWithIndex = new Bundle(itemForårsløg);
            itemForårsløgWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 19);

            Bundle itemGlaskålWithIndex = new Bundle(itemGlaskål);
            itemGlaskålWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 20);

            Bundle itemGrønkålWithIndex = new Bundle(itemGrønkål);
            itemGrønkålWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 21);

            Bundle itemFarvetGulerodWithIndex = new Bundle(itemFarvetGulerod);
            itemFarvetGulerodWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 22);

            Bundle itemGulerødderWithIndex = new Bundle(itemGulerødder);
            itemGulerødderWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 23);

            Bundle itemHindbærWithIndex = new Bundle(itemHindbær);
            itemHindbærWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 24);

            Bundle itemHjertesalatWithIndex = new Bundle(itemHjertesalat);
            itemHjertesalatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 25);

            Bundle itemHokkaidoWithIndex = new Bundle(itemHokkaido);
            itemHokkaidoWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 26);

            Bundle itemHovedsalatWithIndex = new Bundle(itemHovedsalat);
            itemHovedsalatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 27);

            Bundle itemHvidkålWithIndex = new Bundle(itemHvidkål);
            itemHvidkålWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 28);

            Bundle itemIcebergWithIndex = new Bundle(itemIceberg);
            itemIcebergWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 29);

            Bundle itemJordbærWithIndex = new Bundle(itemJordbær);
            itemJordbærWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 30);

            Bundle itemJordskokkerWithIndex = new Bundle(itemJordskokker);
            itemJordskokkerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 31);

            Bundle itemKejserhatWithIndex = new Bundle(itemKejserhat);
            itemKejserhatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 32);

            Bundle itemKinakålWithIndex = new Bundle(itemKinakål);
            itemKinakålWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 33);

            Bundle itemKirsebærWithIndex = new Bundle(itemKirsebær);
            itemKirsebærWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 34);

            Bundle itemKnoldselleriWithIndex = new Bundle(itemKnoldselleri);
            itemKnoldselleriWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 35);

            Bundle itemKorianderWithIndex = new Bundle(itemKoriander);
            itemKorianderWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 36);

            Bundle itemLøgWithIndex = new Bundle(itemLøg);
            itemLøgWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 37);

            Bundle itemMajroeWithIndex = new Bundle(itemMajroe);
            itemMajroeWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 38);

            Bundle itemMajskolbeWithIndex = new Bundle(itemMajskolbe);
            itemMajskolbeWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 39);

            Bundle itemMerianWithIndex = new Bundle(itemMerian);
            itemMerianWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 40);

            Bundle itemMynteWithIndex = new Bundle(itemMynte);
            itemMynteWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 41);

            Bundle itemNetmelonWithIndex = new Bundle(itemNetmelon);
            itemNetmelonWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 42);

            Bundle itemOreganoWithIndex = new Bundle(itemOregano);
            itemOreganoWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 43);

            Bundle itemPakChoyWithIndex = new Bundle(itemPakChoy);
            itemPakChoyWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 44);

            Bundle itemPastinakWithIndex = new Bundle(itemPastinak);
            itemPastinakWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 45);

            Bundle itemPeberfrugtWithIndex = new Bundle(itemPeberfrugt);
            itemPeberfrugtWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 46);

            Bundle itemPeberrodWithIndex = new Bundle(itemPeberrod);
            itemPeberrodWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 47);

            Bundle itemPersilleWithIndex = new Bundle(itemPersille);
            itemPersilleWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 48);

            Bundle itemPorreWithIndex = new Bundle(itemPorre);
            itemPorreWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 49);

            Bundle itemPortobelloWithIndex = new Bundle(itemPortobello);
            itemPortobelloWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 50);

            Bundle itemPurløgWithIndex = new Bundle(itemPurløg);
            itemPurløgWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 51);

            Bundle itemPærerWithIndex = new Bundle(itemPærer);
            itemPærerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 52);

            Bundle itemRabarberWithIndex = new Bundle(itemRabarber);
            itemRabarberWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 53);

            Bundle itemRadiserWithIndex = new Bundle(itemRadiser);
            itemRadiserWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 54);

            Bundle itemRibsWithIndex = new Bundle(itemRibs);
            itemRibsWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 55);

            Bundle itemRosenkålWithIndex = new Bundle(itemRosenkål);
            itemRosenkålWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 56);

            Bundle itemRosmarinWithIndex = new Bundle(itemRosmarin);
            itemRosmarinWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 57);

            Bundle itemRucolaWithIndex = new Bundle(itemRucola);
            itemRucolaWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 58);

            Bundle itemRødbedeWithIndex = new Bundle(itemRødbede);
            itemRødbedeWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 59);

            Bundle itemRødkålWithIndex = new Bundle(itemRødkål);
            itemRødkålWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 60);

            Bundle itemRødløgWithIndex = new Bundle(itemRødløg);
            itemRødløgWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 61);

            Bundle itemSalvieWithIndex = new Bundle(itemSalvie);
            itemSalvieWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 62);

            Bundle itemSavoykålWithIndex = new Bundle(itemSavoykål);
            itemSavoykålWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 63);

            Bundle itemShiitakeWithIndex = new Bundle(itemShiitake);
            itemShiitakeWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 64);

            Bundle itemSkalotteløgWithIndex = new Bundle(itemSkalotteløg);
            itemSkalotteløgWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 65);

            Bundle itemSolbærWithIndex = new Bundle(itemSolbær);
            itemSolbærWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 66);

            Bundle itemSpidskålWithIndex = new Bundle(itemSpidskål);
            itemSpidskålWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 67);

            Bundle itemSpinatWithIndex = new Bundle(itemSpinat);
            itemSpinatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 68);

            Bundle itemSpirerWithIndex = new Bundle(itemSpirer);
            itemSpirerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 69);

            Bundle itemSquashWithIndex = new Bundle(itemSquash);
            itemSquashWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 70);

            Bundle itemStikkelsbærWithIndex = new Bundle(itemStikkelsbær);
            itemStikkelsbærWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 71);

            Bundle itemTimianWithIndex = new Bundle(itemTimian);
            itemTimianWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 72);

            Bundle itemTomatWithIndex = new Bundle(itemTomat);
            itemTomatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 73);

            Bundle itemÆblerWithIndex = new Bundle(itemÆbler);
            itemÆblerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 74);

            Bundle itemÆrterWithIndex = new Bundle(itemÆrter);
            itemÆrterWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 75);

            Bundle itemÆrteskudWithIndex = new Bundle(itemÆrteskud);
            itemÆrteskudWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 76);

            Bundle itemØstershatWithIndex = new Bundle(itemØstershat);
            itemØstershatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 77);


            Bundle viewItemListParams = new Bundle();
            viewItemListParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            viewItemListParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food selection");
            viewItemListParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                    new Parcelable[]{itemAgurkWithIndex, itemAspargesWithIndex, itemBasilikumWithIndex,
                            itemBladselleriWithIndex, itemBlomkålWithIndex, itemBlommerWithIndex,
                            itemBlåbærWithIndex, itemBroccoliWithIndex, itemBrombærWithIndex,
                            itemBøgehatWithIndex, itemChampignonWithIndex, itemChilliWithIndex,
                            itemCitronmelisseWithIndex, itemDildWithIndex, itemEstragonWithIndex,
                            itemFarvetGulerodWithIndex, itemFeldsalatWithIndex, itemFenikkelWithIndex,
                            itemForårsløgWithIndex, itemGlaskålWithIndex, itemGrønkålWithIndex,
                            itemGrønneBønnerWithIndex, itemGulerødderWithIndex, itemHindbærWithIndex,
                            itemHjertesalatWithIndex, itemHokkaidoWithIndex, itemHovedsalatWithIndex,
                            itemHvidkålWithIndex, itemIcebergWithIndex, itemJordbærWithIndex,
                            itemJordskokkerWithIndex, itemKejserhatWithIndex, itemKinakålWithIndex,
                            itemKirsebærWithIndex, itemKnoldselleriWithIndex, itemKorianderWithIndex,
                            itemLøgWithIndex, itemMajroeWithIndex, itemMajskolbeWithIndex,
                            itemMerianWithIndex, itemMynteWithIndex, itemNetmelonWithIndex,
                            itemOreganoWithIndex, itemPakChoyWithIndex, itemPastinakWithIndex,
                            itemPeberfrugtWithIndex, itemPeberrodWithIndex, itemPersilleWithIndex,
                            itemPorreWithIndex, itemPortobelloWithIndex, itemPurløgWithIndex,
                            itemPærerWithIndex, itemRabarberWithIndex, itemRadiserWithIndex,
                            itemRibsWithIndex, itemRosenkålWithIndex, itemRosmarinWithIndex,
                            itemRucolaWithIndex, itemRødbedeWithIndex, itemRødkålWithIndex,
                            itemRødløgWithIndex, itemSalvieWithIndex, itemSavoykålWithIndex,
                            itemShiitakeWithIndex, itemSkalotteløgWithIndex, itemSolbærWithIndex,
                            itemSpidskålWithIndex, itemSpinatWithIndex, itemSpirerWithIndex,
                            itemSquashWithIndex, itemStikkelsbærWithIndex, itemTimianWithIndex,
                            itemTomatWithIndex, itemÆblerWithIndex, itemÆrterWithIndex,
                            itemÆrteskudWithIndex, itemØstershatWithIndex});
            analytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM_LIST, viewItemListParams);

            /*Select a product from list*/
           /* Bundle selectItemParams = new Bundle();
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                    new Parcelable[]{ itemAgurk });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemAsparges });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBasilikum });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBladselleri });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBlomkål });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBlommer });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBlåbær });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBroccoli });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBrombær });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);



            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBøgehat });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemChampignon });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemChilli });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemCitronmelisse });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemDild });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemEstragon });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemFarvetGulerod });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemFeldsalat });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemFenikkel });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemForårsløg });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemGlaskål });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemGrønkål });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemGrønneBønner });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemGulerødder });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemHindbær });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemHjertesalat });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{  itemHokkaido });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemHovedsalat });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{  itemHvidkål });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemIceberg });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemJordbær });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemJordskokker });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemKejserhat });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemKinakål });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemKirsebær });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemKnoldselleri });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemKoriander });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);

            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemLøg });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemMajroe });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemMajskolbe });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemMerian });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);

            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemMynte });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemNetmelon });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemOregano });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemPakChoy });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemPastinak });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemPeberfrugt });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemPeberrod });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemPersille });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);

            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemPorre });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemPortobello });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemPurløg });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemPærer });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{  itemRabarber });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemRadiser });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemRibs });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemRosenkål });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemRosmarin });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemRucola });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemRødbede });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemRødkål });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemRødløg });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSalvie });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSavoykål });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemShiitake });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSkalotteløg });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSolbær });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSpidskål });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSpinat });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSpirer });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSquash });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemStikkelsbær });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{  itemTimian });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);

            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemTomat });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemÆbler });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);

            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemÆrter });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{  itemÆrteskud });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{  itemØstershat });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);

        return inflater.inflate(R.layout.fragment_products, container, false);
    }
}
*/