package com.example.vongship_android.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vongship_android.R;

public class NotificationFragment extends Fragment {
    ListView listView;
    String mTitle[] = {"Chiều rồi!Trà sữa nào bạn ơi! Đồng giá 17K, freeship nữa nà",
            "Sáng nay ăn gì, cứ lên Loship, đặt ngay thôi nào, đồng giá 10K lại free ship tận nhà",
            " Yêu một người là khi \n Mình nghĩ về người đó \n Cứ mỗi sáng nhắn nhỏ \n Loship rồi hay chưa?",
            "Trần Thị Huệ đã hoàn thành đơn hàng đầu tiên với mã giới thiệu của bạn. Bạn nhận được 10.000đ",
            "Chiều nay uống gì nhỉ, lên Loship liền đồng giá 29K mà còn được freeship tận nhà nè",
            " Nụ cười ươm tia nắng \n Ánh mắt đầy ngọt ngào \n Loship nhanh đi chớ \n Anh đang chờ sáng nay",
            "Loship chưa thấy bạn đặt? Tặng mã THOMNGON, giảm 20.000đ khi đặt đơn hàng đầu tiên.",
            "Tuy vô lý hết sức nhưng TẶNG mã LAMQUEN là điều không thể ngờ. Giảm 20.000đ cho đơn hàng đầu tiên nhé! Lại còn được Freeship nữa!"};
    String mDescription[]={"4 phút","15 phút","18 phút","1 giờ","19 giờ","23 giờ","1 ngày","1 ngày"};
    int images[] ={R.drawable.trsua,R.drawable.ansang,R.drawable.icon_loship,R.drawable.avatar_meo,R.drawable.douong,R.drawable.icon_loship,R.drawable.icon_loship,R.drawable.icon_loship};


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications,container,false);
        listView = root.findViewById(R.id.ListView);
        NotificationFragment.MyAdapter adapter = new NotificationFragment.MyAdapter( getActivity(), mTitle,mDescription,images);
        listView.setAdapter(adapter);
        return root;
        };
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        MyAdapter (Context c, String title[],String description[],int imgs[] ){
            super(c,R.layout.item_notification, R.id.text,title);
            this.context =c;
            this.rTitle=title;
            this.rDescription=description;
            this.rImgs=imgs;
        }
        @NonNull
        @Override

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.item_notification,parent, false);
            ImageView images= row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.text);
            TextView myDescription = row.findViewById(R.id.time);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}
