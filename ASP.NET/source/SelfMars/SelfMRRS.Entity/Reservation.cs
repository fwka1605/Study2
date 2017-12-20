using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SelfMRRS.Entity
{
    public class Reservation
    {
        public int ReservationId { get; set; }
        public int MeetingRoomId { get; set; } 
        public DateTime ReserveDataFrom { get; set; }
        public DateTime ReserveDateTo { get; set; }
        public string Purpose { get; set; }
        public string Remarks { get; set; }

        public virtual MeetingRoom MeetingRoom { get; set; }  
    }
}
