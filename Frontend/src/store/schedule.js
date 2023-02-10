import { createSlice, current } from "@reduxjs/toolkit";

const initialScheduleState = {
  arr: [],
};

//로그인 관련된 state요소들을 최신화 하는 slice (initialLoginState에 있는 state들을 최신화하는 코드)
const scheduleSlice = createSlice({
  name: "schedule",
  initialState: initialScheduleState,
  reducers: {
    setArr(state, action) {
      state.arr.push(action.payload);
    },
    deleteArr(state, action) {
      for (let i = 0; i < state.arr.length; i++) {
        if (current(state.arr[i]).djName === action.payload) {
          state.arr = state.arr.filter(
            (element) => element.djName != action.payload
          );
        }
        console.log(current(state.arr[i]));
      }
    },
  },
});

export const scheduleActions = scheduleSlice.actions;

//전체다 하지말고 리듀서만 임포트하기 위해
export default scheduleSlice.reducer;
