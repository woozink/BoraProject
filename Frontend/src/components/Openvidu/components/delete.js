import axios from "axios";

const deleteRoom = async (roomId) => {
  try {
    const {
      data: { success },
    } = await axios({
      method: "delete",
      url: "https://i8b301.p.ssafy.io:8445/main/broadcast" + roomId,
    });
    if (success === true) {
      return true;
    } else {
      return false;
    }
  } catch (e) {
    console.error(e);
    return false;
  }
};

export default deleteRoom;
