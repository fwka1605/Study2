using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MRRS.Entity
{
    public class MeetingRoom
    {
        public int MeetingRoomId { get; set; }
        public string MeetingRoomName { get; set; }
        public int LocationId { get; set; }	// （1）

        public virtual Location Location { get; set; }  // （2）
        public virtual ICollection<Reservation> Reservations { get; set; }  // （3）
    }
}
