package td.nhan.lab01_exe02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.zip.Inflater;

import td.nhan.lab01_exe02.model.Student;

public class StudentAdapter extends ArrayAdapter<Student> {

    List<Student> studentList;
    int textViewResourceId;

    public StudentAdapter(@NonNull Context context, List<Student> resource, int textViewResourceId) {
        super(context, textViewResourceId, resource);
        this.studentList = resource;
        this.textViewResourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Student student = studentList.get(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(textViewResourceId, parent, false);

        ImageView imageView = convertView.findViewById(R.id.img);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvDob = convertView.findViewById(R.id.tvDob);
        Button btnDel = convertView.findViewById(R.id.btnDel);

        imageView.setImageResource(student.getResImg());
        tvName.setText(student.getName());
        tvDob.setText(student.getDob());

        btnDel.setOnClickListener(v -> {
            studentList.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}
