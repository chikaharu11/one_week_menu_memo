package com.example.b

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mRealm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        mRealm = Realm.getInstance(realmConfig)

        val cuisines = mutableSetOf(

            "[空にする]",
            "ハンバーグ",
            "ギョーザ",
            "焼きウインナー",
            "肉野菜炒め",
            "唐揚げ",
            "豚汁",
            "マーボー豆腐",
            "マーボー春雨",
            "人参しりしり",
            "煮付け",
            "焼きそば",
            "焼きワンタン",
            "チャーハン",
            "豚生姜焼き",
            "エビフライ",
            "キノコ炒め",
            "ビーフン炒め",
            "チキングラタン",
            "ミートグラタン",
            "シチュー",
            "ビーフシチュー",
            "うどん",
            "パスタ",
            "鯖マヨ",
            "ジャガチーズ焼き",
            "ハムカツ",
            "サイコロステーキ",
            "チキンステーキ",
            "オムライス",
            "肉じゃが㋬",
            "牛丼",
            "豚バラ白菜㋬",
            "カレー㋬",
            "八宝菜",
            "ラーメン",
            "チーズ餃子",
            "焼きハム",
            "けんちん汁㋬",
            "ラザニア",
            "サンドイッチ",
            "冷やし中華",
            "マーボー茄子",
            "あんかけ卵"
        )

        button.setOnClickListener {
            val stringText = editText4.text.toString()
            if (stringText != "") {
                create(stringText)
            }
            val stringText2 = editText7.text.toString()
            if (stringText2 != "") {
                create2(stringText2)
            }
            val stringText3 = editText4n.text.toString()
            if (stringText3 != "") {
                create3(stringText3)
            }
            val stringText4 = editText7n.text.toString()
            if (stringText4 != "") {
                create4(stringText4)
            }
        }

        editText8.setOnClickListener {
            delete()
        }


        val getcuisines1 = mRealm.where<Book>().equalTo("id", 0.toLong()).findFirst()?.name
        val getcuisines2 = mRealm.where<Book>().equalTo("id", 1.toLong()).findFirst()?.name
        val getcuisines3 = mRealm.where<Book>().equalTo("id", 2.toLong()).findFirst()?.name
        val getcuisines4 = mRealm.where<Book>().equalTo("id", 3.toLong()).findFirst()?.name
        val getcuisines5 = mRealm.where<Book>().equalTo("id", 4.toLong()).findFirst()?.name
        val getcuisines6 = mRealm.where<Book>().equalTo("id", 5.toLong()).findFirst()?.name
        val getcuisines7 = mRealm.where<Book>().equalTo("id", 6.toLong()).findFirst()?.name
        val getcuisines8 = mRealm.where<Book>().equalTo("id", 7.toLong()).findFirst()?.name
        val getcuisines9 = mRealm.where<Book>().equalTo("id", 8.toLong()).findFirst()?.name
        val getcuisines10 = mRealm.where<Book>().equalTo("id", 9.toLong()).findFirst()?.name
        val getcuisines11 = mRealm.where<Book>().equalTo("id", 10.toLong()).findFirst()?.name
        val getcuisines12 = mRealm.where<Book>().equalTo("id", 11.toLong()).findFirst()?.name
        val getcuisines13 = mRealm.where<Book>().equalTo("id", 12.toLong()).findFirst()?.name
        val getcuisines14 = mRealm.where<Book>().equalTo("id", 13.toLong()).findFirst()?.name
        val getcuisines15 = mRealm.where<Book>().equalTo("id", 14.toLong()).findFirst()?.name




        if (getcuisines1 != null) {
            cuisines.add(getcuisines1.toString())
        }
        if (getcuisines2 != null) {
            cuisines.add(getcuisines2.toString())
        }
        if (getcuisines3 != null) {
            cuisines.add(getcuisines3.toString())
        }
        if (getcuisines4 != null) {
            cuisines.add(getcuisines4.toString())
        }
        if (getcuisines5 != null) {
            cuisines.add(getcuisines5.toString())
        }
        if (getcuisines6 != null) {
            cuisines.add(getcuisines6.toString())
        }
        if (getcuisines7 != null) {
            cuisines.add(getcuisines7.toString())
        }
        if (getcuisines8 != null) {
            cuisines.add(getcuisines8.toString())
        }
        if (getcuisines9 != null) {
            cuisines.add(getcuisines9.toString())
        }
        if (getcuisines10 != null) {
            cuisines.add(getcuisines10.toString())
        }
        if (getcuisines11 != null) {
            cuisines.add(getcuisines11.toString())
        }
        if (getcuisines12 != null) {
            cuisines.add(getcuisines12.toString())
        }
        if (getcuisines13 != null) {
            cuisines.add(getcuisines13.toString())
        }
        if (getcuisines14 != null) {
            cuisines.add(getcuisines14.toString())
        }
        if (getcuisines15 != null) {
            cuisines.add(getcuisines15.toString())
        }



        val spinnerItems = cuisines.sorted()

        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner1.adapter = adapter
        spinner2.adapter = adapter
        spinner3.adapter = adapter
        spinner4.adapter = adapter
        spinner5.adapter = adapter
        spinner6.adapter = adapter
        spinner7.adapter = adapter


        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText8.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText4.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText10.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText11.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText12.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText13.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val clumsiness = mutableSetOf(

            "[空にする]",
            "生野菜",
            "豆腐",
            "パウチサラダ",
            "レンジ野菜",
            "シューマイ",
            "きゅうり酢和え",
            "ツナレタスサラダ",
            "ショーロンポー",
            "こんぶキャベツ",
            "レンジ豚もやし",
            "のりきゅうり",
            "茶碗むし",
            "レンジコロッケ",
            "じゃがブロッコリー",
            "スティックサラダ",
            "味噌田楽",
            "かぼちゃチーズ",
            "マカロニサラダ",
            "フライドポテト",
            "大学いも",
            "卵豆腐",
            "レンジ青椒肉絲",
            "春巻",
            "レンジ唐揚げ",
            "コーンスープ"
        )

        val getclumsiness1 = mRealm.where<Book2>().equalTo("id", 0.toLong()).findFirst()?.name
        val getclumsiness2 = mRealm.where<Book2>().equalTo("id", 1.toLong()).findFirst()?.name
        val getclumsiness3 = mRealm.where<Book2>().equalTo("id", 2.toLong()).findFirst()?.name
        val getclumsiness4 = mRealm.where<Book2>().equalTo("id", 3.toLong()).findFirst()?.name
        val getclumsiness5 = mRealm.where<Book2>().equalTo("id", 4.toLong()).findFirst()?.name
        val getclumsiness6 = mRealm.where<Book2>().equalTo("id", 5.toLong()).findFirst()?.name
        val getclumsiness7 = mRealm.where<Book2>().equalTo("id", 6.toLong()).findFirst()?.name
        val getclumsiness8 = mRealm.where<Book2>().equalTo("id", 7.toLong()).findFirst()?.name
        val getclumsiness9 = mRealm.where<Book2>().equalTo("id", 8.toLong()).findFirst()?.name
        val getclumsiness10 = mRealm.where<Book2>().equalTo("id", 9.toLong()).findFirst()?.name
        val getclumsiness11 = mRealm.where<Book2>().equalTo("id", 10.toLong()).findFirst()?.name
        val getclumsiness12 = mRealm.where<Book2>().equalTo("id", 11.toLong()).findFirst()?.name
        val getclumsiness13 = mRealm.where<Book2>().equalTo("id", 12.toLong()).findFirst()?.name
        val getclumsiness14 = mRealm.where<Book2>().equalTo("id", 13.toLong()).findFirst()?.name
        val getclumsiness15 = mRealm.where<Book2>().equalTo("id", 14.toLong()).findFirst()?.name

        clumsiness.add(getclumsiness1.toString())
        clumsiness.add(getclumsiness2.toString())
        clumsiness.add(getclumsiness3.toString())

        val spinnerItems2 = clumsiness.sorted()

        val adapter2 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems2
        )

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinnerA.adapter = adapter2
        spinnerB.adapter = adapter2
        spinnerC.adapter = adapter2
        spinnerD.adapter = adapter2
        spinnerE.adapter = adapter2
        spinnerF.adapter = adapter2
        spinnerG.adapter = adapter2


        spinnerB.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText9.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerF.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText7.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerG.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText14.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerD.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText15.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerE.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText16.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerC.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText17.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerA.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText18.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        editText8.setOnLongClickListener {
            spinner1.performClick()
            true
        }
        editText4.setOnLongClickListener {
            spinner4.performClick()
            true
        }
        editText.setOnLongClickListener {
            spinner3.performClick()
            true
        }
        editText10.setOnLongClickListener {
            spinner7.performClick()
            true
        }
        editText11.setOnLongClickListener {
            spinner6.performClick()
            true
        }
        editText12.setOnLongClickListener {
            spinner2.performClick()
            true
        }
        editText13.setOnLongClickListener {
            spinner5.performClick()
            true
        }
        editText9.setOnLongClickListener {
            spinnerB.performClick()
            true
        }
        editText7.setOnLongClickListener {
            spinnerF.performClick()
            true
        }
        editText14.setOnLongClickListener {
            spinnerG.performClick()
            true
        }
        editText15.setOnLongClickListener {
            spinnerD.performClick()
            true
        }
        editText16.setOnLongClickListener {
            spinnerE.performClick()
            true
        }
        editText17.setOnLongClickListener {
            spinnerC.performClick()
            true
        }
        editText18.setOnLongClickListener {
            spinnerA.performClick()
            true
        }

        val lunches = mutableSetOf(

            "[空にする]",
            "皿うどん",
            "ギョーザ",
            "焼きそば",
            "マーボー春雨",
            "マーボー豆腐",
            "沖縄そば",
            "冷凍パスタ",
            "すき焼き豆腐",
            "レトルトカレー",
            "豚しょうが焼き",
            "ハンバーグ",
            "あんかけ卵",
            "肉野菜炒め",
            "ビーフン炒め"
        )

        val getlunches1 = mRealm.where<Book3>().equalTo("id", 0.toLong()).findFirst()?.name
        val getlunches2 = mRealm.where<Book3>().equalTo("id", 1.toLong()).findFirst()?.name
        val getlunches3 = mRealm.where<Book3>().equalTo("id", 2.toLong()).findFirst()?.name

        lunches.add(getlunches1.toString())
        lunches.add(getlunches2.toString())
        lunches.add(getlunches3.toString())

        val spinnerItems3 = lunches.sorted()

        val adapter3 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems3
        )

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner1n.adapter = adapter3
        spinner2n.adapter = adapter3
        spinner3n.adapter = adapter3
        spinner4n.adapter = adapter3
        spinner5n.adapter = adapter3
        spinner6n.adapter = adapter3
        spinner7n.adapter = adapter3

        spinner1n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText8n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner4n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText4n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner3n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editTextn.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner7n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText10n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner6n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText11n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner2n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText12n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner5n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText13n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val baboon = mutableSetOf(

            "[空にする]",
            "生野菜",
            "シューマイ",
            "ショーロンポー",
            "コロッケ",
            "春巻",
            "レンジ野菜",
            "パウチサラダ",
            "お湯スープ",
            "沖縄そば",
            "冷凍唐揚げ",
            "茶碗蒸し",
            "レンジ豚もやし"
        )

        val getbaboon1 = mRealm.where<Book4>().equalTo("id", 0.toLong()).findFirst()?.name
        val getbaboon2 = mRealm.where<Book4>().equalTo("id", 1.toLong()).findFirst()?.name
        val getbaboon3 = mRealm.where<Book4>().equalTo("id", 2.toLong()).findFirst()?.name

        baboon.add(getbaboon1.toString())
        baboon.add(getbaboon2.toString())
        baboon.add(getbaboon3.toString())

        val spinnerItems4 = baboon.sorted()

        val adapter4 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems4
        )

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerAn.adapter = adapter4
        spinnerBn.adapter = adapter4
        spinnerCn.adapter = adapter4
        spinnerDn.adapter = adapter4
        spinnerEn.adapter = adapter4
        spinnerFn.adapter = adapter4
        spinnerGn.adapter = adapter4

        spinnerBn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText9n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerFn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText7n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerGn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText14n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerDn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText15n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerEn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText16n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerCn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText17n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerAn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText18n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        editText8n.setOnLongClickListener {
            spinner1n.performClick()
            true
        }
        editText4n.setOnLongClickListener {
            spinner4n.performClick()
            true
        }
        editTextn.setOnLongClickListener {
            spinner3n.performClick()
            true
        }
        editText10n.setOnLongClickListener {
            spinner7n.performClick()
            true
        }
        editText11n.setOnLongClickListener {
            spinner6n.performClick()
            true
        }
        editText12n.setOnLongClickListener {
            spinner2n.performClick()
            true
        }
        editText13n.setOnLongClickListener {
            spinner5n.performClick()
            true
        }
        editText9n.setOnLongClickListener {
            spinnerBn.performClick()
            true
        }
        editText7n.setOnLongClickListener {
            spinnerFn.performClick()
            true
        }
        editText14n.setOnLongClickListener {
            spinnerGn.performClick()
            true
        }
        editText15n.setOnLongClickListener {
            spinnerDn.performClick()
            true
        }
        editText16n.setOnLongClickListener {
            spinnerEn.performClick()
            true
        }
        editText17n.setOnLongClickListener {
            spinnerCn.performClick()
            true
        }
        editText18n.setOnLongClickListener {
            spinnerAn.performClick()
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mRealm.close()
    }

    private fun create(name: String) {
        mRealm.executeTransaction {
            val max = mRealm.where<Book>().max("id")
            var newId: Long = 0
            if (max != null) {//nullチェック
                newId = max.toLong() + 1
            }
            val book = mRealm.createObject<Book>(primaryKeyValue = newId)
            book.name = name
            mRealm.copyToRealm(book)
        }
    }

    private fun create2(name: String) {
        mRealm.executeTransaction {
            val max = mRealm.where<Book2>().max("id")
            var newId: Long = 0
            if (max != null) {//nullチェック
                newId = max.toLong() + 1
            }
            val book = mRealm.createObject<Book2>(primaryKeyValue = newId)
            book.name = name
            mRealm.copyToRealm(book)
        }
    }

    private fun create3(name: String) {
        mRealm.executeTransaction {
            val max = mRealm.where<Book3>().max("id")
            var newId: Long = 0
            if (max != null) {//nullチェック
                newId = max.toLong() + 1
            }
            val book = mRealm.createObject<Book3>(primaryKeyValue = newId)
            book.name = name
            mRealm.copyToRealm(book)
        }
    }

    private fun create4(name: String) {
        mRealm.executeTransaction {
            val max = mRealm.where<Book4>().max("id")
            var newId: Long = 0
            if (max != null) {//nullチェック
                newId = max.toLong() + 1
            }
            val book = mRealm.createObject<Book4>(primaryKeyValue = newId)
            book.name = name
            mRealm.copyToRealm(book)
        }
    }

    /*private fun read(): RealmResults<Book> {
        return mRealm.where(Book::class.java).findAll()
    }
*/
    private fun delete() {
        mRealm.executeTransaction {
            mRealm.deleteAll()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_options_menu_list, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val fragment1 = MenuListFragmentActivity1()
        val fragment2 = MenuListFragmentActivity2()
        val fragment3 = MenuListFragmentActivity3()
        val fragment4 = MenuListFragmentActivity4()


        fun replaceFragment(fragment: Fragment) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.replace(R.id.container, fragment)
            fragmentTransaction.commit()
        }

        when (item.itemId) {

            R.id.MenuList1 -> {
                replaceFragment(fragment1)
                return true
            }

            R.id.MenuList2 -> {
                replaceFragment(fragment2)
                return true
            }

            R.id.MenuList3 -> {
                replaceFragment(fragment3)
                return true
            }

            R.id.MenuList4 -> {
                replaceFragment(fragment4)
                return true
            }

            R.id.MenuList5 -> {
                supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                return true
            }

            R.id.MenuList6 -> {

                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}