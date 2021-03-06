package com.example.p8_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.firebase.analytics.FirebaseAnalytics;

public class ProductsFragment extends Fragment {

    FirebaseAnalytics analytics;
    FirebaseAnalytics mFirebaseAnalytics;
    Bundle item;
    String name;
    String text;

    private Object Context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        /*Database items*/
            Bundle itemAgurk = new Bundle();
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

            Bundle itemBlomk??l = new Bundle();
            itemBlomk??l.putString(FirebaseAnalytics.Param.ITEM_ID, "5");
            itemBlomk??l.putString(FirebaseAnalytics.Param.ITEM_NAME, "blomk??l");
            itemBlomk??l.putDouble(FirebaseAnalytics.Param.PRICE, 19.00);
            itemBlomk??l.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBlommer = new Bundle();
            itemBlommer.putString(FirebaseAnalytics.Param.ITEM_ID, "6");
            itemBlommer.putString(FirebaseAnalytics.Param.ITEM_NAME, "blommer");
            itemBlommer.putDouble(FirebaseAnalytics.Param.PRICE, 2.50);
            itemBlommer.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBl??b??r = new Bundle();
            itemBl??b??r.putString(FirebaseAnalytics.Param.ITEM_ID, "7");
            itemBl??b??r.putString(FirebaseAnalytics.Param.ITEM_NAME, "bl??b??r");
            itemBl??b??r.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemBl??b??r.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBroccoli = new Bundle();
            itemBroccoli.putString(FirebaseAnalytics.Param.ITEM_ID, "8");
            itemBroccoli.putString(FirebaseAnalytics.Param.ITEM_NAME, "broccoli");
            itemBroccoli.putDouble(FirebaseAnalytics.Param.PRICE, 14.00);
            itemBroccoli.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemBromb??r = new Bundle();
            itemBromb??r.putString(FirebaseAnalytics.Param.ITEM_ID, "9");
            itemBromb??r.putString(FirebaseAnalytics.Param.ITEM_NAME, "bromb??r");
            itemBromb??r.putDouble(FirebaseAnalytics.Param.PRICE, 22.00);
            itemBromb??r.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemB??gehat = new Bundle();
            itemB??gehat.putString(FirebaseAnalytics.Param.ITEM_ID, "10");
            itemB??gehat.putString(FirebaseAnalytics.Param.ITEM_NAME, "b??gehat");
            itemB??gehat.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemB??gehat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemGr??nneB??nner = new Bundle();
            itemGr??nneB??nner.putString(FirebaseAnalytics.Param.ITEM_ID, "11");
            itemGr??nneB??nner.putString(FirebaseAnalytics.Param.ITEM_NAME, "gr??nne_b??nner");
            itemGr??nneB??nner.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemGr??nneB??nner.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

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

            Bundle itemFor??rsl??g = new Bundle();
            itemFor??rsl??g.putString(FirebaseAnalytics.Param.ITEM_ID, "19");
            itemFor??rsl??g.putString(FirebaseAnalytics.Param.ITEM_NAME, "for??rsl??g");
            itemFor??rsl??g.putDouble(FirebaseAnalytics.Param.PRICE, 6.00);
            itemFor??rsl??g.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemGlask??l = new Bundle();
            itemGlask??l.putString(FirebaseAnalytics.Param.ITEM_ID, "20");
            itemGlask??l.putString(FirebaseAnalytics.Param.ITEM_NAME, "glask??l");
            itemGlask??l.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemGlask??l.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemGr??nk??l = new Bundle();
            itemGr??nk??l.putString(FirebaseAnalytics.Param.ITEM_ID, "21");
            itemGr??nk??l.putString(FirebaseAnalytics.Param.ITEM_NAME, "gr??nk??l");
            itemGr??nk??l.putDouble(FirebaseAnalytics.Param.PRICE, 22.00);
            itemGr??nk??l.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemFarvetGulerod = new Bundle();
            itemFarvetGulerod.putString(FirebaseAnalytics.Param.ITEM_ID, "22");
            itemFarvetGulerod.putString(FirebaseAnalytics.Param.ITEM_NAME, "farvet_gulerod");
            itemFarvetGulerod.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemFarvetGulerod.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemGuler??dder = new Bundle();
            itemGuler??dder.putString(FirebaseAnalytics.Param.ITEM_ID, "23");
            itemGuler??dder.putString(FirebaseAnalytics.Param.ITEM_NAME, "guler??dder");
            itemGuler??dder.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemGuler??dder.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemHindb??r = new Bundle();
            itemHindb??r.putString(FirebaseAnalytics.Param.ITEM_ID, "24");
            itemHindb??r.putString(FirebaseAnalytics.Param.ITEM_NAME, "hindb??r");
            itemHindb??r.putDouble(FirebaseAnalytics.Param.PRICE, 22.00);
            itemHindb??r.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

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

            Bundle itemHvidk??l = new Bundle();
            itemHvidk??l.putString(FirebaseAnalytics.Param.ITEM_ID, "28");
            itemHvidk??l.putString(FirebaseAnalytics.Param.ITEM_NAME, "hvidk??l");
            itemHvidk??l.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemHvidk??l.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemIceberg = new Bundle();
            itemIceberg.putString(FirebaseAnalytics.Param.ITEM_ID, "29");
            itemIceberg.putString(FirebaseAnalytics.Param.ITEM_NAME, "iceberg");
            itemIceberg.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemIceberg.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemJordb??r = new Bundle();
            itemJordb??r.putString(FirebaseAnalytics.Param.ITEM_ID, "30");
            itemJordb??r.putString(FirebaseAnalytics.Param.ITEM_NAME, "jordb??r");
            itemJordb??r.putDouble(FirebaseAnalytics.Param.PRICE, 25.00);
            itemJordb??r.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

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

            Bundle itemKinak??l = new Bundle();
            itemKinak??l.putString(FirebaseAnalytics.Param.ITEM_ID, "33");
            itemKinak??l.putString(FirebaseAnalytics.Param.ITEM_NAME, "kinak??l");
            itemKinak??l.putDouble(FirebaseAnalytics.Param.PRICE, 21.00);
            itemKinak??l.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemKirseb??r = new Bundle();
            itemKirseb??r.putString(FirebaseAnalytics.Param.ITEM_ID, "34");
            itemKirseb??r.putString(FirebaseAnalytics.Param.ITEM_NAME, "kirseb??r");
            itemKirseb??r.putDouble(FirebaseAnalytics.Param.PRICE, 25.00);
            itemKirseb??r.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

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

            Bundle itemL??g = new Bundle();
            itemL??g.putString(FirebaseAnalytics.Param.ITEM_ID, "37");
            itemL??g.putString(FirebaseAnalytics.Param.ITEM_NAME, "l??g");
            itemL??g.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemL??g.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

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

            Bundle itemPurl??g = new Bundle();
            itemPurl??g.putString(FirebaseAnalytics.Param.ITEM_ID, "51");
            itemPurl??g.putString(FirebaseAnalytics.Param.ITEM_NAME, "purl??g");
            itemPurl??g.putDouble(FirebaseAnalytics.Param.PRICE, 7.00);
            itemPurl??g.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemP??rer = new Bundle();
            itemP??rer.putString(FirebaseAnalytics.Param.ITEM_ID, "52");
            itemP??rer.putString(FirebaseAnalytics.Param.ITEM_NAME, "p??rer");
            itemP??rer.putDouble(FirebaseAnalytics.Param.PRICE, 2.50);
            itemP??rer.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

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

            Bundle itemRosenk??l = new Bundle();
            itemRosenk??l.putString(FirebaseAnalytics.Param.ITEM_ID, "56");
            itemRosenk??l.putString(FirebaseAnalytics.Param.ITEM_NAME, "rosenk??l");
            itemRosenk??l.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemRosenk??l.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

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

            Bundle itemR??dbede = new Bundle();
            itemR??dbede.putString(FirebaseAnalytics.Param.ITEM_ID, "59");
            itemR??dbede.putString(FirebaseAnalytics.Param.ITEM_NAME, "r??dbede");
            itemR??dbede.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
            itemR??dbede.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemR??dk??l = new Bundle();
            itemR??dk??l.putString(FirebaseAnalytics.Param.ITEM_ID, "60");
            itemR??dk??l.putString(FirebaseAnalytics.Param.ITEM_NAME, "r??dk??l");
            itemR??dk??l.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemR??dk??l.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemR??dl??g = new Bundle();
            itemR??dl??g.putString(FirebaseAnalytics.Param.ITEM_ID, "61");
            itemR??dl??g.putString(FirebaseAnalytics.Param.ITEM_NAME, "r??dl??g");
            itemR??dl??g.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemR??dl??g.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSalvie = new Bundle();
            itemSalvie.putString(FirebaseAnalytics.Param.ITEM_ID, "62");
            itemSalvie.putString(FirebaseAnalytics.Param.ITEM_NAME, "salvie");
            itemSalvie.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemSalvie.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSavoyk??l = new Bundle();
            itemSavoyk??l.putString(FirebaseAnalytics.Param.ITEM_ID, "63");
            itemSavoyk??l.putString(FirebaseAnalytics.Param.ITEM_NAME, "savoyk??l");
            itemSavoyk??l.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            itemSavoyk??l.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemShiitake = new Bundle();
            itemShiitake.putString(FirebaseAnalytics.Param.ITEM_ID, "64");
            itemShiitake.putString(FirebaseAnalytics.Param.ITEM_NAME, "shiitake");
            itemShiitake.putDouble(FirebaseAnalytics.Param.PRICE, 30.00);
            itemShiitake.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSkalottel??g = new Bundle();
            itemSkalottel??g.putString(FirebaseAnalytics.Param.ITEM_ID, "65");
            itemSkalottel??g.putString(FirebaseAnalytics.Param.ITEM_NAME, "skalottel??g");
            itemSkalottel??g.putDouble(FirebaseAnalytics.Param.PRICE, 12.00);
            itemSkalottel??g.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSolb??r = new Bundle();
            itemSolb??r.putString(FirebaseAnalytics.Param.ITEM_ID, "66");
            itemSolb??r.putString(FirebaseAnalytics.Param.ITEM_NAME, "solb??r");
            itemSolb??r.putDouble(FirebaseAnalytics.Param.PRICE, 15.00);
            itemSolb??r.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle itemSpidsk??l = new Bundle();
            itemSpidsk??l.putString(FirebaseAnalytics.Param.ITEM_ID, "67");
            itemSpidsk??l.putString(FirebaseAnalytics.Param.ITEM_NAME, "spidsk??l");
            itemSpidsk??l.putDouble(FirebaseAnalytics.Param.PRICE, 13.00);
            itemSpidsk??l.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

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

            Bundle itemStikkelsb??r = new Bundle();
            itemStikkelsb??r.putString(FirebaseAnalytics.Param.ITEM_ID, "71");
            itemStikkelsb??r.putString(FirebaseAnalytics.Param.ITEM_NAME, "stikkelsb??r");
            itemStikkelsb??r.putDouble(FirebaseAnalytics.Param.PRICE, 32.00);
            itemStikkelsb??r.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

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

            Bundle item??bler = new Bundle();
            item??bler.putString(FirebaseAnalytics.Param.ITEM_ID, "74");
            item??bler.putString(FirebaseAnalytics.Param.ITEM_NAME, "??bler");
            item??bler.putDouble(FirebaseAnalytics.Param.PRICE, 2.50);
            item??bler.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle item??rter = new Bundle();
            item??rter.putString(FirebaseAnalytics.Param.ITEM_ID, "75");
            item??rter.putString(FirebaseAnalytics.Param.ITEM_NAME, "??rter");
            item??rter.putDouble(FirebaseAnalytics.Param.PRICE, 12.00);
            item??rter.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle item??rteskud = new Bundle();
            item??rteskud.putString(FirebaseAnalytics.Param.ITEM_ID, "76");
            item??rteskud.putString(FirebaseAnalytics.Param.ITEM_NAME, "??rteskud");
            item??rteskud.putDouble(FirebaseAnalytics.Param.PRICE, 20.00);
            item??rteskud.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            Bundle item??stershat = new Bundle();
            item??stershat.putString(FirebaseAnalytics.Param.ITEM_ID, "77");
            item??stershat.putString(FirebaseAnalytics.Param.ITEM_NAME, "??stershat");
            item??stershat.putDouble(FirebaseAnalytics.Param.PRICE, 25.00);
            item??stershat.putString(FirebaseAnalytics.Param.ORIGIN, "Danmark");

            /*Select product from a list*/
            Bundle itemAgurkWithIndex = new Bundle(itemAgurk);
            itemAgurkWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 1);

            Bundle itemAspargesWithIndex = new Bundle(itemAsparges);
            itemAspargesWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 2);

            Bundle itemBasilikumWithIndex = new Bundle(itemBasilikum);
            itemBasilikumWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 3);

            Bundle itemBladselleriWithIndex = new Bundle(itemBladselleri);
            itemBladselleriWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 4);

            Bundle itemBlomk??lWithIndex = new Bundle(itemBlomk??l);
            itemBlomk??lWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 5);

            Bundle itemBlommerWithIndex = new Bundle(itemBlommer);
            itemBlommerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 6);

            Bundle itemBl??b??rWithIndex = new Bundle(itemBl??b??r);
            itemBl??b??rWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 7);

            Bundle itemBroccoliWithIndex = new Bundle(itemBroccoli);
            itemBroccoliWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 8);

            Bundle itemBromb??rWithIndex = new Bundle(itemBromb??r);
            itemBromb??rWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 9);

            Bundle itemB??gehatWithIndex = new Bundle(itemB??gehat);
            itemB??gehatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 10);

            Bundle itemGr??nneB??nnerWithIndex = new Bundle(itemGr??nneB??nner);
            itemGr??nneB??nnerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 11);

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

            Bundle itemFor??rsl??gWithIndex = new Bundle(itemFor??rsl??g);
            itemFor??rsl??gWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 19);

            Bundle itemGlask??lWithIndex = new Bundle(itemGlask??l);
            itemGlask??lWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 20);

            Bundle itemGr??nk??lWithIndex = new Bundle(itemGr??nk??l);
            itemGr??nk??lWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 21);

            Bundle itemFarvetGulerodWithIndex = new Bundle(itemFarvetGulerod);
            itemFarvetGulerodWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 22);

            Bundle itemGuler??dderWithIndex = new Bundle(itemGuler??dder);
            itemGuler??dderWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 23);

            Bundle itemHindb??rWithIndex = new Bundle(itemHindb??r);
            itemHindb??rWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 24);

            Bundle itemHjertesalatWithIndex = new Bundle(itemHjertesalat);
            itemHjertesalatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 25);

            Bundle itemHokkaidoWithIndex = new Bundle(itemHokkaido);
            itemHokkaidoWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 26);

            Bundle itemHovedsalatWithIndex = new Bundle(itemHovedsalat);
            itemHovedsalatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 27);

            Bundle itemHvidk??lWithIndex = new Bundle(itemHvidk??l);
            itemHvidk??lWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 28);

            Bundle itemIcebergWithIndex = new Bundle(itemIceberg);
            itemIcebergWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 29);

            Bundle itemJordb??rWithIndex = new Bundle(itemJordb??r);
            itemJordb??rWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 30);

            Bundle itemJordskokkerWithIndex = new Bundle(itemJordskokker);
            itemJordskokkerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 31);

            Bundle itemKejserhatWithIndex = new Bundle(itemKejserhat);
            itemKejserhatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 32);

            Bundle itemKinak??lWithIndex = new Bundle(itemKinak??l);
            itemKinak??lWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 33);

            Bundle itemKirseb??rWithIndex = new Bundle(itemKirseb??r);
            itemKirseb??rWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 34);

            Bundle itemKnoldselleriWithIndex = new Bundle(itemKnoldselleri);
            itemKnoldselleriWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 35);

            Bundle itemKorianderWithIndex = new Bundle(itemKoriander);
            itemKorianderWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 36);

            Bundle itemL??gWithIndex = new Bundle(itemL??g);
            itemL??gWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 37);

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

            Bundle itemPurl??gWithIndex = new Bundle(itemPurl??g);
            itemPurl??gWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 51);

            Bundle itemP??rerWithIndex = new Bundle(itemP??rer);
            itemP??rerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 52);

            Bundle itemRabarberWithIndex = new Bundle(itemRabarber);
            itemRabarberWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 53);

            Bundle itemRadiserWithIndex = new Bundle(itemRadiser);
            itemRadiserWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 54);

            Bundle itemRibsWithIndex = new Bundle(itemRibs);
            itemRibsWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 55);

            Bundle itemRosenk??lWithIndex = new Bundle(itemRosenk??l);
            itemRosenk??lWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 56);

            Bundle itemRosmarinWithIndex = new Bundle(itemRosmarin);
            itemRosmarinWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 57);

            Bundle itemRucolaWithIndex = new Bundle(itemRucola);
            itemRucolaWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 58);

            Bundle itemR??dbedeWithIndex = new Bundle(itemR??dbede);
            itemR??dbedeWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 59);

            Bundle itemR??dk??lWithIndex = new Bundle(itemR??dk??l);
            itemR??dk??lWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 60);

            Bundle itemR??dl??gWithIndex = new Bundle(itemR??dl??g);
            itemR??dl??gWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 61);

            Bundle itemSalvieWithIndex = new Bundle(itemSalvie);
            itemSalvieWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 62);

            Bundle itemSavoyk??lWithIndex = new Bundle(itemSavoyk??l);
            itemSavoyk??lWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 63);

            Bundle itemShiitakeWithIndex = new Bundle(itemShiitake);
            itemShiitakeWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 64);

            Bundle itemSkalottel??gWithIndex = new Bundle(itemSkalottel??g);
            itemSkalottel??gWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 65);

            Bundle itemSolb??rWithIndex = new Bundle(itemSolb??r);
            itemSolb??rWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 66);

            Bundle itemSpidsk??lWithIndex = new Bundle(itemSpidsk??l);
            itemSpidsk??lWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 67);

            Bundle itemSpinatWithIndex = new Bundle(itemSpinat);
            itemSpinatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 68);

            Bundle itemSpirerWithIndex = new Bundle(itemSpirer);
            itemSpirerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 69);

            Bundle itemSquashWithIndex = new Bundle(itemSquash);
            itemSquashWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 70);

            Bundle itemStikkelsb??rWithIndex = new Bundle(itemStikkelsb??r);
            itemStikkelsb??rWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 71);

            Bundle itemTimianWithIndex = new Bundle(itemTimian);
            itemTimianWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 72);

            Bundle itemTomatWithIndex = new Bundle(itemTomat);
            itemTomatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 73);

            Bundle item??blerWithIndex = new Bundle(item??bler);
            item??blerWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 74);

            Bundle item??rterWithIndex = new Bundle(item??rter);
            item??rterWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 75);

            Bundle item??rteskudWithIndex = new Bundle(item??rteskud);
            item??rteskudWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 76);

            Bundle item??stershatWithIndex = new Bundle(item??stershat);
            item??stershatWithIndex.putLong(FirebaseAnalytics.Param.INDEX, 77);


            Bundle viewItemListParams = new Bundle();
            viewItemListParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            viewItemListParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food selection");
            viewItemListParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                    new Parcelable[]{itemAgurkWithIndex, itemAspargesWithIndex, itemBasilikumWithIndex,
                            itemBladselleriWithIndex, itemBlomk??lWithIndex, itemBlommerWithIndex,
                            itemBl??b??rWithIndex, itemBroccoliWithIndex, itemBromb??rWithIndex,
                            itemB??gehatWithIndex, itemChampignonWithIndex, itemChilliWithIndex,
                            itemCitronmelisseWithIndex, itemDildWithIndex, itemEstragonWithIndex,
                            itemFarvetGulerodWithIndex, itemFeldsalatWithIndex, itemFenikkelWithIndex,
                            itemFor??rsl??gWithIndex, itemGlask??lWithIndex, itemGr??nk??lWithIndex,
                            itemGr??nneB??nnerWithIndex, itemGuler??dderWithIndex, itemHindb??rWithIndex,
                            itemHjertesalatWithIndex, itemHokkaidoWithIndex, itemHovedsalatWithIndex,
                            itemHvidk??lWithIndex, itemIcebergWithIndex, itemJordb??rWithIndex,
                            itemJordskokkerWithIndex, itemKejserhatWithIndex, itemKinak??lWithIndex,
                            itemKirseb??rWithIndex, itemKnoldselleriWithIndex, itemKorianderWithIndex,
                            itemL??gWithIndex, itemMajroeWithIndex, itemMajskolbeWithIndex,
                            itemMerianWithIndex, itemMynteWithIndex, itemNetmelonWithIndex,
                            itemOreganoWithIndex, itemPakChoyWithIndex, itemPastinakWithIndex,
                            itemPeberfrugtWithIndex, itemPeberrodWithIndex, itemPersilleWithIndex,
                            itemPorreWithIndex, itemPortobelloWithIndex, itemPurl??gWithIndex,
                            itemP??rerWithIndex, itemRabarberWithIndex, itemRadiserWithIndex,
                            itemRibsWithIndex, itemRosenk??lWithIndex, itemRosmarinWithIndex,
                            itemRucolaWithIndex, itemR??dbedeWithIndex, itemR??dk??lWithIndex,
                            itemR??dl??gWithIndex, itemSalvieWithIndex, itemSavoyk??lWithIndex,
                            itemShiitakeWithIndex, itemSkalottel??gWithIndex, itemSolb??rWithIndex,
                            itemSpidsk??lWithIndex, itemSpinatWithIndex, itemSpirerWithIndex,
                            itemSquashWithIndex, itemStikkelsb??rWithIndex, itemTimianWithIndex,
                            itemTomatWithIndex, item??blerWithIndex, item??rterWithIndex,
                            item??rteskudWithIndex, item??stershatWithIndex});
            analytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM_LIST, viewItemListParams);

            /*Select a product from list*/
            Bundle selectItemParams = new Bundle();
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
                new Parcelable[]{ itemBlomk??l });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBlommer });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBl??b??r });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBroccoli });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemBromb??r });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);



            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemB??gehat });
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
                new Parcelable[]{ itemFor??rsl??g });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemGlask??l });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemGr??nk??l });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemGr??nneB??nner });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemGuler??dder });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemHindb??r });
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
                new Parcelable[]{  itemHvidk??l });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemIceberg });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemJordb??r });
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
                new Parcelable[]{ itemKinak??l });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemKirseb??r });
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
                new Parcelable[]{ itemL??g });
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
                new Parcelable[]{ itemPurl??g });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemP??rer });
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
                new Parcelable[]{ itemRosenk??l });
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
                new Parcelable[]{ itemR??dbede });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemR??dk??l });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemR??dl??g });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSalvie });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSavoyk??l });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemShiitake });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSkalottel??g });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSolb??r });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ itemSpidsk??l });
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
                new Parcelable[]{ itemStikkelsb??r });
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
                new Parcelable[]{ item??bler });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);

            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{ item??rter });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{  item??rteskud });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);


            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_ID, "L001");
            selectItemParams.putString(FirebaseAnalytics.Param.ITEM_LIST_NAME, "Food Selection");
            selectItemParams.putParcelableArray(FirebaseAnalytics.Param.ITEMS,
                new Parcelable[]{  item??stershat });
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, selectItemParams);

        return inflater.inflate(R.layout.fragment_products, container, false);
    }
}