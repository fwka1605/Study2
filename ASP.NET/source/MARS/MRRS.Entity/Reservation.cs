using System;

namespace MRRS.Entity
{
    public class Reservation
    {
        public int ReservationId { get; set; }
        public int MeetingRoomId { get; set; }  // （1）
        public DateTime ReserveDataFrom { get; set; }
        public DateTime ReserveDateTo { get; set; }
        public string Purpose { get; set; }
        public string Remarks { get; set; }

        public virtual MeetingRoom MeetingRoom { get; set; }  // （2）
    }
}