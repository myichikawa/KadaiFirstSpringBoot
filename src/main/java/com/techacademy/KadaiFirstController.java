package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class KadaiFirstController {
    @GetMapping("dayofweek/{val}")
    public String dispDayOfWeek(@PathVariable String val) {
//パスパラメータを年月日に分割
        String y = val.substring(0,4);
        String m = val.substring(4,6);
        String d = val.substring(6);
//int型に変換
        int yn =Integer.parseInt(y);
        int mn =Integer.parseInt(m);
        int dn =Integer.parseInt(d);
//localdateのインスタンスを生成
       LocalDate localDate =LocalDate.of(yn, mn ,dn);
//曜日の取得
       DayOfWeek dayOfWeek = localDate.getDayOfWeek();
//dayofweek型から表示用の文字列を取得する
       return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
      int res = 0;
      res = val1 + val2;
      String s = String.valueOf(res);
      return s;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
      int res = 0;
      res = val1 - val2;
      String s = String.valueOf(res);
      return s;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
      int res = 0;
      res = val1 * val2;
      String s = String.valueOf(res);
      return s;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
      int res = 0;
      res = val1 / val2;
      String s = String.valueOf(res);
      return s;
    }

}
