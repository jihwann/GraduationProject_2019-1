package com.example.graduationproject_2019_1.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import com.example.graduationproject_2019_1.R;

public class SearchActivity extends Activity implements TextWatcher {
    ListView listview;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;
    static final String[] address_List = {
            "종로구 청운효자동", "종로구 사직동", "종로구 삼청동", "종로구 부암동", "종로구 평창동", "종로구 무악동", "종로구 교남동", "종로구 가회동", "종로구 종로1.2.3.4가동", "종로구 종로5.6가동", "종로구 이화동", "종로구 혜화동", "종로구 창신제1동", "종로구 창신제2동", "종로구 창신제3동", "종로구 숭인제1동", "종로구 숭인제2동", "중구 소공동", "중구 회현동", "중구 명동", "중구 필동", "중구 장충동", "중구 광희동", "중구 을지로동", "중구 신당동", "중구 다산동", "중구 약수동", "중구 청구동", "중구 신당제5동", "중구 동화동", "중구 황학동", "중구 중림동", "용산구 후암동", "용산구 용산2가동", "용산구 남영동", "용산구 청파동", "용산구 원효로제1동", "용산구 원효로제2동", "용산구 효창동", "용산구 용문동", "용산구 한강로동", "용산구 이촌제1동", "용산구 이촌제2동", "용산구 이태원제1동", "용산구 이태원제2동", "용산구 한남동", "용산구 서빙고동", "용산구 보광동", "성동구 왕십리제2동", "성동구 왕십리도선동", "성동구 마장동", "성동구 사근동", "성동구 행당제1동", "성동구 행당제2동", "성동구 응봉동", "성동구 금호1가동", "성동구 금호2.3가동", "성동구 금호4가동", "성동구 옥수동", "성동구 성수1가제1동", "성동구 성수1가제2동", "성동구 성수2가제1동", "성동구 성수2가제3동", "성동구 송정동", "성동구 용답동", "광진구 화양동", "광진구 군자동", "광진구 중곡제1동", "광진구 중곡제2동", "광진구 중곡제3동", "광진구 중곡제4동", "광진구 능동", "광진구 광장동", "광진구 자양제1동", "광진구 자양제2동", "광진구 자양제3동", "광진구 자양제4동", "광진구 구의제1동", "광진구 구의제2동", "광진구 구의제3동", "동대문구 용신동", "동대문구 제기동", "동대문구 전농제1동", "동대문구 전농제2동", "동대문구 답십리제1동", "동대문구 답십리제2동", "동대문구 장안제1동", "동대문구 장안제2동", "동대문구 청량리동", "동대문구 회기동", "동대문구 휘경제1동", "동대문구 휘경제2동", "동대문구 이문제1동", "동대문구 이문제2동", "중랑구 면목제2동", "중랑구 면목제4동", "중랑구 면목제5동", "중랑구 면목본동", "중랑구 면목제7동", "중랑구 면목제3.8동", "중랑구 상봉제1동", "중랑구 상봉제2동", "중랑구 중화제1동", "중랑구 중화제2동", "중랑구 묵제1동", "중랑구 묵제2동", "중랑구 망우본동", "중랑구 망우제3동", "중랑구 신내1동", "중랑구 신내2동", "성북구 성북동", "성북구 삼선동2가", "성북구 동선동", "성북구 돈암제1동", "성북구 돈암제2동", "성북구 안암동", "성북구 보문동", "성북구 정릉제1동", "성북구 정릉제2동", "성북구 정릉제3동", "성북구 정릉제4동", "성북구 길음제1동", "성북구 길음제2동", "성북구 종암동", "성북구 월곡제1동", "성북구 월곡제2동", "성북구 장위제1동", "성북구 장위제2동", "성북구 장위제3동", "성북구 석관동", "강북구 삼양동", "강북구 미아동", "강북구 송중동", "강북구 송천동", "강북구 삼각산동", "강북구 번제1동", "강북구 번제2동", "강북구 번제3동", "강북구 수유제1동", "강북구 수유제2동", "강북구 수유제3동", "강북구 우이동", "강북구 인수동", "도봉구 창제1동", "도봉구 창제2동", "도봉구 창제3동", "도봉구 창제4동", "도봉구 창제5동", "도봉구 도봉제1동", "도봉구 도봉제2동", "도봉구 쌍문제1동", "도봉구 쌍문제2동", "도봉구 쌍문제3동", "도봉구 쌍문제4동", "도봉구 방학제1동", "도봉구 방학제2동", "도봉구 방학제3동", "노원구 월계1동", "노원구 월계2동", "노원구 월계3동", "노원구 공릉1동", "노원구 공릉2동", "노원구 하계1동", "노원구 하계2동", "노원구 중계본동", "노원구 중계1동", "노원구 중계4동", "노원구 중계2.3동", "노원구 상계1동", "노원구 상계2동", "노원구 상계3.4동", "노원구 상계5동", "노원구 상계6.7동", "노원구 상계8동", "노원구 상계9동", "노원구 상계10동", "은평구 녹번동", "은평구 불광제1동", "은평구 불광제2동", "은평구 갈현제1동", "은평구 갈현제2동", "은평구 구산동", "은평구 대조동", "은평구 응암제1동", "은평구 응암제2동", "은평구 응암제3동", "은평구 역촌동", "은평구 신사제1동", "은평구 신사제2동", "은평구 증산동", "은평구 수색동", "은평구 진관동", "서대문구 천연동", "서대문구 북아현동", "서대문구 충현동", "서대문구 신촌동", "서대문구 연희동", "서대문구 홍제제1동", "서대문구 홍제제3동", "서대문구 홍제제2동", "서대문구 홍은제1동", "서대문구 홍은제2동", "서대문구 남가좌제1동", "서대문구 남가좌제2동", "서대문구 북가좌제1동", "서대문구 북가좌제2동", "마포구 아현동", "마포구 공덕동", "마포구 도화동", "마포구 용강동", "마포구 대흥동", "마포구 염리동", "마포구 신수동", "마포구 서강동", "마포구 서교동", "마포구 합정동", "마포구 망원제1동", "마포구 망원제2동", "마포구 연남동", "마포구 성산제1동", "마포구 성산제2동", "마포구 상암동", "양천구 목1동", "양천구 목2동", "양천구 목3동", "양천구 목4동", "양천구 목5동", "양천구 신월1동", "양천구 신월2동", "양천구 신월3동", "양천구 신월4동", "양천구 신월5동", "양천구 신월6동", "양천구 신월7동", "양천구 신정1동", "양천구 신정2동", "양천구 신정3동", "양천구 신정4동", "양천구 신정6동", "양천구 신정7동", "강서구 염창동", "강서구 등촌제1동", "강서구 등촌제2동", "강서구 등촌제3동", "강서구 화곡제1동", "강서구 화곡제2동", "강서구 화곡제3동", "강서구 화곡제4동", "강서구 화곡본동", "강서구 화곡제6동", "강서구 화곡제8동", "강서구 가양제1동", "강서구 가양제2동", "강서구 가양제3동", "강서구 발산제1동", "강서구 우장산동", "강서구 공항동", "강서구 방화제1동", "강서구 방화제2동", "강서구 방화제3동", "구로구 신도림동", "구로구 구로제1동", "구로구 구로제2동", "구로구 구로제3동", "구로구 구로제4동", "구로구 구로제5동", "구로구 가리봉동", "구로구 고척제1동", "구로구 고척제2동", "구로구 개봉제1동", "구로구 개봉제2동", "구로구 개봉제3동", "구로구 오류제1동", "구로구 오류제2동", "구로구 수궁동", "금천구 가산동", "금천구 독산제1동", "금천구 독산제2동", "금천구 독산제3동", "금천구 독산제4동", "금천구 시흥제1동", "금천구 시흥제2동", "금천구 시흥제3동", "금천구 시흥제4동", "금천구 시흥제5동", "영등포구 영등포본동", "영등포구 영등포동", "영등포구 여의동", "영등포구 당산1동", "영등포구 당산2동", "영등포구 도림동", "영등포구 문래동", "영등포구 양평제1동", "영등포구 양평제2동", "영등포구 신길제1동", "영등포구 신길제3동", "영등포구 신길제4동", "영등포구 신길제5동", "영등포구 신길제6동", "영등포구 신길제7동", "영등포구 대림제1동", "영등포구 대림제2동", "영등포구 대림제3동", "동작구 노량진제1동", "동작구 노량진제2동", "동작구 상도제1동", "동작구 상도제2동", "동작구 상도제3동", "동작구 상도제4동", "동작구 흑석동", "동작구 사당제1동", "동작구 사당제2동", "동작구 사당제3동", "동작구 사당제4동", "동작구 사당제5동", "동작구 대방동", "동작구 신대방제1동", "동작구 신대방제2동", "관악구 보라매동", "관악구 청림동", "관악구 성현동", "관악구 행운동", "관악구 낙성대동", "관악구 청룡동", "관악구 은천동", "관악구 중앙동", "관악구 인헌동", "관악구 남현동", "관악구 서원동", "관악구 신원동", "관악구 서림동", "관악구 신사동", "관악구 신림동", "관악구 난향동", "관악구 조원동", "관악구 대학동", "관악구 삼성동", "관악구 미성동", "관악구 난곡동", "서초구 서초1동", "서초구 서초2동", "서초구 서초3동", "서초구 서초4동", "서초구 잠원동", "서초구 반포본동", "서초구 반포1동", "서초구 반포2동", "서초구 반포3동", "서초구 반포4동", "서초구 방배본동", "서초구 방배1동", "서초구 방배2동", "서초구 방배3동", "서초구 방배4동", "서초구 양재1동", "서초구 양재2동", "서초구 내곡동", "강남구 신사동", "강남구 논현1동", "강남구 논현2동", "강남구 압구정동", "강남구 청담동", "강남구 삼성1동", "강남구 삼성2동", "강남구 대치1동", "강남구 대치2동", "강남구 대치4동", "강남구 역삼1동", "강남구 역삼2동", "강남구 도곡1동", "강남구 도곡2동", "강남구 개포1동", "강남구 개포2동", "강남구 개포4동", "강남구 세곡동", "강남구 일원본동", "강남구 일원1동", "강남구 일원2동", "강남구 수서동", "송파구 풍납1동", "송파구 풍납2동", "송파구 거여1동", "송파구 거여2동", "송파구 마천1동", "송파구 마천2동", "송파구 방이1동", "송파구 방이2동", "송파구 오륜동", "송파구 오금동", "송파구 송파1동", "송파구 송파2동", "송파구 석촌동", "송파구 삼전동", "송파구 가락본동", "송파구 가락1동", "송파구 가락2동", "송파구 문정1동", "송파구 문정2동", "송파구 장지동", "송파구 위례동", "송파구 잠실본동", "송파구 잠실2동", "송파구 잠실3동", "송파구 잠실4동", "송파구 잠실6동", "송파구 잠실7동", "강동구 강일동", "강동구 상일동", "강동구 명일제1동", "강동구 명일제2동", "강동구 고덕제1동", "강동구 고덕제2동", "강동구 암사제1동", "강동구 암사제2동", "강동구 암사제3동", "강동구 천호제1동", "강동구 천호제2동", "강동구 천호제3동", "강동구 성내제1동", "강동구 성내제2동", "강동구 성내제3동", "강동구 길동", "강동구 둔촌제1동", "강동구 둔촌제2동"
    };
    String[] arrayLocation = {null, null};
    boolean send_or_not = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listview = (ListView) findViewById(R.id.search_listView);
        editText = (EditText) findViewById(R.id.search_editText);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, address_List);

        listview.setAdapter(arrayAdapter);
        listview.setTextFilterEnabled(true);
        editText.addTextChangedListener(this);

        ImageButton close_btn = findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                arrayLocation = strText.split(" "); // 지금 이거 해야됨!!!!!!!!!!!!!!!!!!!!
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                intent.putExtra("searching_location_gu", arrayLocation[0]);
                intent.putExtra("searching_location_dong", arrayLocation[1]);
                intent.putExtra("send_or_not", send_or_not);
                startActivity(intent);
            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        //listview.setFilterText(editText.getText().toString());
//        if(editText.getText().toString().contains("\n")){
//            listview.setFilterText(editText.getText().toString().replace("\n", " "));
//        }
//        else{
//            listview.setFilterText(editText.getText().toString());
//        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        String filterText = editText.getText().toString() ;
//        if (filterText.length() > 0) {
//            listview.setFilterText(filterText) ;
//        } else {
//            listview.clearTextFilter() ;
//        }
        ((ArrayAdapter)listview.getAdapter()).getFilter().filter(filterText) ;
//        if(editText.getText().length() == 0){
//            listview.clearTextFilter();
//        }
    }
}
