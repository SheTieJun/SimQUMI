/*
 * Tencent is pleased to support the open source community by making QMUI_Android available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the MIT License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.shetj.qmui.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import me.shetj.qmui.R;


/**
 *
 * @author cginechen
 * @date 2016-09-22
 */
public class QMUIResHelper {

    public static float getAttrFloatValue(Context context, int attrRes){
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(attrRes, typedValue, true);
        return typedValue.getFloat();
    }

    public static int getAttrColor(Context context, int attrRes){
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(attrRes, typedValue, true);
        return typedValue.data;
    }

    public static ColorStateList getAttrColorStateList(Context context, int attrRes){
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(attrRes, typedValue, true);
        return ContextCompat.getColorStateList(context, typedValue.resourceId);
    }

    public static Drawable getAttrDrawable(Context context, int attrRes){
        int[] attrs = new int[] { attrRes };
        TypedArray ta = context.obtainStyledAttributes(attrs);
        Drawable drawable = getAttrDrawable(context, ta, 0);
        ta.recycle();
        return drawable;
    }

    public static Drawable getAttrDrawable(Context context, TypedArray typedArray, int index){
        TypedValue value = typedArray.peekValue(index);
        if(value != null){
            if(value.type != TypedValue.TYPE_ATTRIBUTE && value.resourceId != 0){
                return QMUIDrawableHelper.getVectorDrawable(context, value.resourceId);
            }
        }
        return null;
    }

    /**
     * 获取 DisplayMetrics
     *
     * @return
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }


    public static int getAttrDimen(Context context, int attrRes){
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(attrRes, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, getDisplayMetrics(context));
    }
}
