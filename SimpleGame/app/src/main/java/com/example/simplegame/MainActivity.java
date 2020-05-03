package com.example.simplegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ImageView mIv1,mIv2;
    private Button mbtnSubmit;
    private RadioGroup P1,P2;
    private RadioButton S1,S2,R1,R2,Pa1,Pa2;
    private TextView mtvP1,mtvP2,mtvRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIv1 = findViewById(R.id.iv_1);
        mIv2 = findViewById(R.id.iv_2);
        P1 = findViewById(R.id.rg_1);
        P2 = findViewById(R.id.rg_2);
        S1 = findViewById(R.id.rb_14Scissor);
        S2 = findViewById(R.id.rb_24Scissor);
        R1 = findViewById(R.id.rb_14Rock);
        R2 = findViewById(R.id.rb_24Rock);
        Pa1 = findViewById(R.id.rb_14Paper);
        Pa2 = findViewById(R.id.rb_24Paper);
        mbtnSubmit = findViewById(R.id.btn_submit);
        mtvP1 = findViewById(R.id.tv_point1);
        mtvP2 = findViewById(R.id.tv_point2);
        mtvRe = findViewById(R.id.tv_result);

        final int[] Point1 = {0};
        final int[] Point2 = {0};


        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(P1.getCheckedRadioButtonId() == S1.getId() & P2.getCheckedRadioButtonId() == S2.getId()){
                    mtvRe.setText("平局");
                    mtvP1.setText("P1得分：" + Point1[0]);
                    mtvP2.setText("P2得分："+ Point2[0]);
                    Toast.makeText(MainActivity.this,"平局",Toast.LENGTH_LONG).show();
                }else if(P1.getCheckedRadioButtonId() == S1.getId() & P2.getCheckedRadioButtonId() == R2.getId()){
                    mtvRe.setText("P2获胜");
                    Point2[0]++;
                    mtvP1.setText("P1得分：" + Point1[0]);
                    mtvP2.setText("P2得分："+ Point2[0]);
                    Toast.makeText(MainActivity.this,"P2获胜",Toast.LENGTH_LONG).show();
                }else if(P1.getCheckedRadioButtonId() == S1.getId() & P2.getCheckedRadioButtonId() == Pa2.getId()){
                    mtvRe.setText("P1获胜");
                    Point1[0]++;
                    mtvP1.setText("P1得分：" + Point1[0]);
                    mtvP2.setText("P2得分："+ Point2[0]);
                    Toast.makeText(MainActivity.this,"P1获胜",Toast.LENGTH_LONG).show();
                }else if(P1.getCheckedRadioButtonId() == R1.getId() & P2.getCheckedRadioButtonId() == S2.getId()){
                    mtvRe.setText("P1获胜");
                    Point1[0]++;
                    mtvP1.setText("P1得分：" + Point1[0]);
                    mtvP2.setText("P2得分："+ Point2[0]);
                    Toast.makeText(MainActivity.this,"P1获胜",Toast.LENGTH_LONG).show();
                }else if(P1.getCheckedRadioButtonId() == R1.getId() & P2.getCheckedRadioButtonId() == R2.getId()){
                    mtvRe.setText("平局");
                    mtvP1.setText("P1得分：" + Point1[0]);
                    mtvP2.setText("P2得分："+ Point2[0]);
                    Toast.makeText(MainActivity.this,"平局",Toast.LENGTH_LONG).show();
                }else if(P1.getCheckedRadioButtonId() == R1.getId() & P2.getCheckedRadioButtonId() == Pa2.getId()){
                    mtvRe.setText("P2获胜");
                    Point2[0]++;
                    mtvP1.setText("P1得分：" + Point1[0]);
                    mtvP2.setText("P2得分："+ Point2[0]);
                    Toast.makeText(MainActivity.this,"P2获胜",Toast.LENGTH_LONG).show();
                }else if(P1.getCheckedRadioButtonId() == Pa1.getId() & P2.getCheckedRadioButtonId() == S2.getId()){
                    mtvRe.setText("P2获胜");
                    Point2[0]++;
                    mtvP1.setText("P1得分：" + Point1[0]);
                    mtvP2.setText("P2得分："+ Point2[0]);
                    Toast.makeText(MainActivity.this,"P2获胜",Toast.LENGTH_LONG).show();
                }else if(P1.getCheckedRadioButtonId() == Pa1.getId() & P2.getCheckedRadioButtonId() == R2.getId()){
                    mtvRe.setText("P1获胜");
                    Point1[0]++;
                    mtvP1.setText("P1得分：" + Point1[0]);
                    mtvP2.setText("P2得分："+ Point2[0]);
                    Toast.makeText(MainActivity.this,"P1获胜",Toast.LENGTH_LONG).show();
                }else if(P1.getCheckedRadioButtonId() == Pa1.getId() & P2.getCheckedRadioButtonId() == Pa2.getId()){
                    mtvRe.setText("平局");
                    mtvP1.setText("P1得分：" + Point1[0]);
                    mtvP2.setText("P2得分："+ Point2[0]);
                    Toast.makeText(MainActivity.this,"平局",Toast.LENGTH_LONG).show();
                }
            }
        });

        Glide.with(this).load("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxASEBUQEBAPDxAPEA8PDw8PDw8PDw8PFREWFhUVFRUYHSggGBolHRUVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDg0OFxAQFy0dHR0rKy0tKy0rLS0tLSstLS0rLS0tLS0tLS0tLS0tLS0tLS0tLTctLS0tKy03LS03LS0tLf/AABEIAOIA3wMBEQACEQEDEQH/xAAbAAABBQEBAAAAAAAAAAAAAAABAAIDBAUGB//EADUQAAIBAwIDBgUDBAIDAAAAAAABAgMEEQUhEjFBBiJRYXGBEyMykbEHFFIVQqHB8PEWU2L/xAAbAQACAwEBAQAAAAAAAAAAAAAAAQIDBAUGB//EACYRAAICAQUAAgMAAwEAAAAAAAABAhEDBAUSITETQRQiMhUjUWH/2gAMAwEAAhEDEQA/APHCgzCAAMYwABFIkiaIp8yaLEgABLa0+KSXmRnKkadNi5zSO80qhwwj6HC1E7kz3mjioY6NWK5mNlvPsr3UMosg+y9StHLa/Q7ueuTraWXZ5zdsXKFnPZ7vudD7PHtfsbHZaOai9TJrXUTu7P8A2dVe0OfucnHM9k3yhRxOsUHGZ29PO4nh90wuOVuim6z5FvE5CgiSgyMyEyxgrKhwhEdR7EkSj6QU3uWMtZIQICGAgAQAEAEACwIQgAAxhACCoTRZEuWNnxU5Sa9CueSpUdPBpXKDkZ0l08C5GGSps2tFtc94x6nJ9HoNq0tpSOzowwl6I4s32z1CXGJdpQKGym+yO4jsyUGXRl0c9q9vmDOjp59mLXY+WM42rtt5nZR4XJGps3eyK+Z7mHX/AMnY2lfudtUp5TOGpUeux+nM6xY8XqdPT5uJi1+g+VGN/RpNNroblqV4cHLs8oq0Z0U4tp9DQ/2VnCzY3F8WSqRBoztD+IjRGitWqFsUXRiNpMchyJ0ysrC2AiPJIkFSFQUSCIiAAiIgAYgADGMgw28IndI04ocmkjrbOwf7Zrq8nLyZ/wDYev0ulfwUc7PT5cWDes64nFntuR5KOj0q2cYYObnycnZ6vQ6b4saTOhoR5L0OfJmya6LqWChsy0RV0Sixr0ytSp7GzDKmW5cfOFHB6lR4ZtebO9ilcTweuwvHlZt9jYN1M+GDFr/5OhtK/Y626uorZc9zkQxtnroxrsy6ksmlKjWv57G/CeCXJWZpJNUc5rNk0+NI6Ony2qZ5HdNG03JIzYM0tHm5IdKQkiKRX5ss8RfGNj47PDEyMotEkGQZWwsQkNaGNAySJDuIVEaHRYmJocRIhAAAA2ZJEkS6VS4qhDPKonY2zFzmdvQXyzhy/s9xp4V0U5U1noXKToveGPKyzZx3KsjLcipGpCO6MrMeSTLOSuimxslkaBPsp3MUy6DNcTl9X03ik2dXBnpHF1u3LK7LnZ+1+En/APT+yKtVl5hoND8JqfteJmP5KO70kWoWSSRU8rZVLKqIrmntheBOEiuErZk3FJSTizXCTi7RPPp45IdnJajb/Dn5HXxT5xPBbhpviyNEDexM51dk2m0eKWCOWVI36OHKXY3UIcM2vMMTuJHWRUZ0MgSZgY8iIbJggQ0kSCIQ+mJiY8REWRAIYDKj2GiUUa3Zunu3gy6uXVHrNkwprkdfbRXB7nGm/wBj08ZKLKdzTw/Uug7L7JbJbEMosjs0qPQzSMciwisrQJMaAqVebLomiL6KtWmn0LYyH6NoQwxydodUXbeJRNkJyLTKkZ2Vq0OpZFkoOmZ1xS6mmEvo2xlaOf123zHiOjpZ06OBu+m5Q5nMnTPG0a+iQ3yZNQ+js7bBNkGtx+Y/Unp3+pVucFHIU6TLZHHkSkSIxjGAYxAA+mRZGRIIiIABIARBKRNItjGzp+z9LETm6uVnutnw8cNnVUafcORKX7G+fpXuaGS2E6LoyoFCGNgk7JuVlumUsokicgVcSOcxpEuBDJliLlEYxk/AKG476Eyxbvf/AJ4FcyMl0WSsoYyaGhJFOrHKLos1xdIxtToNppdUbsE+7M2sx/Jio4q4puMmn4s7UHas8BnxuE2jquz1jmlx+f8Ao5ery1Oj0W1Yf0UjF7QR+YbNK/1MG7r/AGGfSNEjhyHsiQFgBiwABwAhIQEgiIgAZMaJIgfMs+i6HqOy0dd1eaONqfWfQ9uVYEdLb/Qjlz/onN9gqoaBMr5LKLUh/FyFRJj+IjRCuxrYyQmgG5DZcvcZKKsghcLiwWOHVg1RYiytiaJI1SLiV1Y91SPEh9kEmTLPor3sfxgtxMaXVHP32lKbyts+50MWpcV2cTVbapys3rO1VOiorw3fmYMuTnOzbp8Pxw4o5DtH9R2NI7ief3lfsZVE1SPOzJWiBCxcIWFiwACwMBOIWFjhCAAAkgQ0QY7y9Sz6NGL+kdppUdkumDi6h9n0Xb1/oR0Vq+6c3J6E49jqookSq0XFyCsCJDkxMj9gAlYsjoKKV1cdEXQgXY+yrnqWkpdE1HUYraTSIywN+GHJq1H0nlqNH/2w+4lpchk/yMF9ip39N8qkfLcjLTyX0PHrYN+ln/JSb4ZVJdEVdZJRdFiZBTpMschp9F+W0cFC9KW6ZwfaSfzMHf0a/U8lvM7mZtBGiR52ZKRICAAAAQAQgFgBWIADgAK01uvUsXhoxPtHaaZ09EcbP9n0Xb3/AKUblN4Rgas0yig8eRUQcSOXIkifiMS+1NwkorLb6I34tOpK2czU69Y3RCr656Ql9ifxYl6zmPdbZJHV6kNqsWs8m1hEXpYy/ll+PcouSsufu3LyKXi4no9O45Y2RtjRakosq3l2oLz6F2PHyZy9fq1iTou9nOyVS6+ZWcoU287c8Mr1W4Q0/wCsfTyk808rbOqh+mNj1qXH3ijn/wCfa+ihxZS1j9M6UYOVvUq8S5ce+X4F+n3tZJVJdEbafRgafdzpP4FdNTi9jXnxxmucD0Gh1PSizTcsmKqPQQacSSjTISZByJa0NiMX2QfZ572kXzH6nodJ/B5HeF+5Qt+Rol6efmSkCAAAQAEAFgAEIQBgPQhFatz9y2Phoxeo7DRpZS9EcfUqmz6Ft008KNzBgNzVhwAqoq31bhhJ9cFuKNySKtRLjFknYLS415uvPEnCSxGXIt3DP8UOKPJ5Z/JNnpyo0YpylCnFJJvurHNHl/lyzf6tmbI4w7ZldqOz9ve2blDhUqeZQcUt2s7HS0OsnhnU/syZMl9xPJ9PbjKVOXOEnH7PB38ytKS+z2ezanlCmXZPYoR2n4ypa01O+oU5bwlUin6dTSusMmeP3TI3Oj2a1jChB/2wp88dIo8dmjLJkowqoQLGla3a3EnTpTUpR5mfU6PNhXKS6M7yp9I0a9FeBljN+jgnZ5P+p9ioVI14pLLjF484p5PZ7Vk54+LNUMnGSM7Tp5is+Q8ypnrNLLljRp262fqZpDm+x9x9JGHo4qzz3tGu+35notH/ACeX3hd2ZtDkaZHmp+kyRWVhYANyMBZAAqQgGjGHACHJCAr1olkWWwdHS9l6mTm62NHttny3io6bJyzs8gtrAqJGZf8Aei15GrF+rRXqcfKDLX6f6vChN0ar4XKWY522zyDc9O8sOUTxeX/Vkdnpus6HK7pcMJ8KlFZlFo89gm9NK3GzLlaydFKtQpaXYTVSspScGoKW7cnnkb4Y5arKp1Rka49I8hsG5znUe3HJv7s72b9YpHs9hwvjbNBrYynpmuihUrOjcUq6WfhyTfsasf7Y3E8pu2BqXKj1bS7uF/bTjGaSqpJvP0803jmefz45afKpNeHCnLlGg9mOw0bKp8WNbj493jJn3Dc3nhwaM0MbTs62vU6vlzycOEDTFnj36oanx1lRi00nF7b7nt9pxccfJlkIOUkVtOhiK9ERzO5HrtKuONGlbvZmaRKT7FdS7osa7L8aOF7RR6+LO/o2eY3pJIyaBqkeVmSyIIrAMYgEHhEAuEAsCGAcioBcQUFDKnIkicTX7H1l8Xhfh/sya+Nws7226rh+p3c6CSOCpuz1OHLyRVuFgth2a4uzLm9zUvDTSa7M+9seJqUXwyXVGnFmpUzja3bVm7RNQ1bUaa4Y154Swt3sgcMEvUcSWzZL6Kl3K5rtOvVnUS5KTbSLFLHBfqi7FsslJNmhSgorC2MspWz1mDDHHCooeRNMSOtSUlhkoS4uzNqsEckGijbTr20viUZtJPLins/LBpl8eZcZI8nrNrlHtHT2v6nV4RUZUG2uu25glsuGTuzkfDlT8K+qfqFdXEeCnT+FlYcs7ksW04cT5N2Tw6XLOXhi0qEpS+JUfFJ888zTKaS4xPT6TQKMbZ0FOOy9DnSfZ0eNKizDGCplVdlPUau2xdhj2aapWcZ2grZxHwO3pY9WeR3vInKkZ1A0SPMzJZEEVoC5DBiAA5EA6LExMjJDEwGIABIENEmk3Hw68ZclnDDPHnjaNeCVSTPVYTUqakt89Tykk4zaZ7HQzuJRvkXYmdWDMiXP3Ni8NaGgSAMjx7Ahk4xCItSoQABjRFgcQspnDkB04+CHyZR+LH/geEVko6ZRdoOALKNam9vYySITTokkyJTGPZRvqqL8USzLJRg7OG1erxVHjxO5gjUTwW5ZeeTojpcicjjyHtkSAgAAAIAHRYmDG5GMTGMQhAkA0QVGWotieldkrtVLRdZRlh+yR53X4eOSz1O1ZU40XLnf7GWB6OBjVo9TZFmxPoiZMlHsQDS7AMG6YRFggAAEWFANLoQEehARcvoSAT8NOnL8GZlE5MfN7MivSEWYWq1uGLy+hvwQtowbjm4YzjW8yz5nZ8R4PLK5Nk8ORWzOxwiNCAQgAIALIANGSCACAAMAK9UsiWxOt7AXDzOHis/g5m5Q6s7O2ZKlR2FxSyjhwkethMyq9I1Rka4yKcol6LsbGDLo+gYyMvQiJiAYgIylQHIdFE8qiitK8WcIsWJ0Y/zYt0izCWdyto0wlY5ETQ10X6JRIyTH1Z4i34IUVbKpZOKOJ1y94nwo7emxcVZ5TdNZyfFGXBGtuzzzZLDkVsgxwCExCFkAoQUAsgAhjEACABABBURNFkS5ouoOjUUujayVajEssKNWny8JHqNvWjUjGUd04rfoeXyY3jbTPW6bOp12Va9PnsTjI6sX0ZdxTZqjI1430V2WE+XZHVrqKzJ4Jxg5eFGp1EYdyIHqNL+aLPgmYHuuJKuQHqVL+SD8ef8Awit2xpf0Vq2rxX07lkdM36YM279/r2Vne1amyWF5FvxQgULU583i6ZfsbDG8ufgZ8uX6R1dFpGu5Ggomezrwiovolp02yDlRPJPo0KVIobOe8tGD2m1HgjwRe7f+DoaPByds4u46/hGonIYcnl82dbxUjyOTI5O2SKBGymxwhBABAAgAQAIAG8QUOhZAQsgOhcQwoa0AyKaJonFnSdkte+HJUqr+W3s/4mDW6Xmrj6dHS6pwkr8O7wpRymmsbNdThSg4Omet0+oU42ihVo5LIyOjjy9UUqlJ+BepFilZRu7TjWH6l2PJxdmXV4PljRjVtGedm/c2x1S+zg5Nom+0Mjocn1G9WiEdmm36W6GjxT72WVy1LfhuxbMl6aVGlGKwkkZpTcjrYtLGCqiaEH0K20bFBJE1Oi87kHIjySL0KOEUOXZTmyRSK2satTt1nKc8YUfM0abTSyPvw8/rtdCKqJ57d3Mqs3OX9zb9DvRgoKkeWy5nN2wwiJmRuxwhCAAgAGAA4hjoSEDHAIYkMY4QhrGMWAAckIBkojTGmR4wTJ2b/Z3tLKj8ufeh0fVGLVaNZO0dLS614ujvLSrTrRUoNbrlnfJwcuOWOVHpdLq4zXo2taMipnSjlKFW2fgXxyFvNP0iduT5lsONDXQHzJriNdEfIUpf8FG39xOYc+ixTosg5lcpUvSxCjjvSaSXi0iPcukYc2dR+zB1jtTGHdpJcS67Nczo4NDfcjz+s3J/yjkqtSdafFN5b/wdNKMI0jz+XK5dsdwJCtsz22AAEABABAAAAWAAQAEAGoBjgEAACACAAAA1xHY0yN0ySkTUizZ6hXotOE5LG/Mrnix5PUaMWplDxm5S7a1sd5J+iRknt0H4b4blNest0u2MMd6Lz1M8tsf0zbHdiSn2roN95P7C/wAdP/pfDd0Tx7R2j6y+wvwJoujvEQ/1+z/k/sR/CyDe7QHx7Q2f8n9gehykf8ukVb/tZSUfld5+aWxPFt0r/Yy5N4vw5q71W4ry2bx0UeR0YafHiRyc2tyTb7GUtOa71XZf5JSy/UTDOT9FcTjnEFiK+7BW/SluyAkAQAQAIAEACAANgMSYCCAASAAiAQCAMYQAAAIAGgMdkKFQ61t1Uk1nhS6jlLibMGB5GTS0uPJVE35rBD5v/C6WmafTA9ErdI59mL8qH2T/AAcjXQv6FX/iP8qH/Q/Ay/8AB0dAuH/Yw/KgP8DKT0+zVX+5qHjki9XH6JR2+f2XP/HYQjxSmpeSxgq/KbdIv/xtRspwu4wbUIpPBJwcu2zj5lwlRVq15S5ssjFLwobIiQhYALEAWIYxAAgADABoEhDEFCBj8CIiaAQAGAYwgAhADIwGjJEct9iS6LMcOTo1balwU3JroZZy5So9Bjw/FitlGhUbnz6l8opRMOKXLIdNC5n4nMlFM9XgiuI/91PxI8ImhRX/AAfSuZZ5icFQ/ijJeGZr97NY3fX8mrTY012cPc8jxUkK0uHOCy8hOCjIs0mT5MfZlXMcVH4GqL/U85uWPjNgYHMGDAIAIAABIQAAYCkCBDQJCAAoBMnwQKxsxoaGDJCGAAAbxDolQGwAWRgW9ItuOW/QrytpdHa23HFytlvWKqjHhX2KcEW3bN+46mKhwRlWS76NOT+Tk6SvkR0mP9HMPZ4l+iCwLB0XuJkzJ7QPl7/k2aXw8zvT7K+l18PhfUszR+zNtmpqXFkuqxxiRHA76J7rBNWU4PYtaPOSQRERAAQGAAEAAGMTAENGSEIQUAMkbIkADAADAMYQAZJDJAQMBMAJKFxKDzB9AaT9NWDUyxeEdWTk8ye41S8IZc8sjtjrH6yOT+TZoUuaOkT/AAjnM9pj/lAyhElON0OTAk5GRrz+n0/2bNN4ea3l9ozKbaeUaX30zgY8jhK0TXFzKez5YIRgol2bVPIqYoAzCwiI0IAEACABAABjEACABAAQAQhCAQgGAYwgA2QDQ1DY2EAFEAYnHYAsOn/X7hl/k6mgX7o6OTws+RzV2z2CdQsyYXb48Z2NbxrjZw4atvPVmrCRkaO7CfIytb5x9/ya9N4ed3r0zkaDzrHAICYDoPEKhUPQiIRCEACGMQAIAGyYIaGqQx0PERDkQhAMQwEAAAASGNDUAxAAgAMnsCBehsPq9xZfDq6D+zcrzxB+higv2PTZ8nHC2c9GT4s+Z0GujyKyP5U//TorWWyOdNdnr9LK42Zusyy4+/5NOnXTOJvM7lRQReefZJCJFsi2TwtnjJBzK3kIalMmmTjIaMkOEREABABAAAAZIaJICGA9ERMICCACAAAAQAZIaGhgyQkDAeIQJsECHWD3Fl8Opo2kzR1CtiOF1M+GNs6Wt1K+OjJ4djX9nnFL9rNayr5il4GTJDs9FpNckqKV/V4pLyL8UeKOdr86ySbRHGJI5TY+JFkWWIVnjGStxKnEhqk4lkSvIsRah8RMiwiEEAEAAABkhokgoAEAFh28vAr5oq5i+BIOaDmhrovwHyQ+SB8NhyQckDgY7HaH07aUuhF5Ehcix/TJeBD50HMEtOklkFmQuZVnSaLVIkppj6VnKXJCeRIfOixbaTPoVz1EScczXhYqaXUfPfBWs8UQyZ5S9YJaZLHQFqFZTydkM7OUUTWVSLI5mikqTyX8icsl9jnAjZDkDAAOi8AJoE5jSGokLJliNO30uUo5WN0mZ5ZUmQbZHU0+ay2lsNZYsCq4NFiaCwQi2DdDbLUbKRW8qIciWlpLkyD1CQcy4uzzxzKvzEHJlWppEk+ZYtSmHM16ttExqbIUR/tl4EvkYqB+2iP5GAlZRD5WAyVhHI/mkOielbwX3ISnJjotqMPAqtjZN8CDWMIjzYqKtXTqfg39i6OWQUOp2UFy/wChSyNhRLwqJVbYn0RyayS7oQZRQkwRVuaKwWwl2JmFXg4s3xaZKJXcmWUWJD6cMiboi2L4bFYchk6L8CSkSUyLh3JWTs6vSV3UvJfg5mZ/sVuRaq0c9CvmFmXd2a8C/HlIWKx05Z5e7DJmdEvTUjZx8jM8jCg/t8MjzsKHPPmhdAyKVNklIiRzJIBowEhgvR7IgxtQaGNGMdT5iYi3EpZIcuaLF4IDIkX6Qy5DXoMZHmNiDUBEYkMiaArXMVwvZci/GBhz5mxFsTQ06K8EUZSEjQ4F4L7IztsgCtBY5L7EoNkkY0kuL3NX0T+jo7HkjnZPRFyfUrGynX5k4+ESe25/chMsRMQJD3z9iJEjYyQgIs//2Q==").into(mIv1);
        Glide.with(this).load("data:image/jpeg;base64,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").into(mIv2);

    }
}
